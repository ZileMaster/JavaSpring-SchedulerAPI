package in.msproject1.schoolscheduler.schedulerAPI.DAO.Termin;

import in.msproject1.schoolscheduler.schedulerAPI.DAO.Grupa.IGrupaDAO;
import in.msproject1.schoolscheduler.schedulerAPI.DAO.Nastavnik.INastavnikDAO;
import in.msproject1.schoolscheduler.schedulerAPI.DAO.Predmet.IPredmetDAO;
import in.msproject1.schoolscheduler.schedulerAPI.DAO.Ucionica.IUcionicaDAO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Grupa;
import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik.Nastavnik;
import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet.Predmet;
import in.msproject1.schoolscheduler.schedulerAPI.model.Termin;
import in.msproject1.schoolscheduler.schedulerAPI.model.Ucionica;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class dbTerminDAO implements ITerminDAO{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private IPredmetDAO predmetDAO;

    @Autowired
    private INastavnikDAO nastavnikDAO;

    @Autowired
    private IUcionicaDAO ucionicaDAO;

    @Autowired
    private IGrupaDAO grupaDAO;

    @Override
    public List<Termin> GetTerminAll() {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Termin> query = currentSession.createQuery("from Termin", Termin.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately
            return Collections.emptyList(); // or another default value
        }
    }

    @Override
    public Termin GetTerminSingle(int id) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Termin> query = currentSession.createQuery("from Termin where id = :id", Termin.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }catch (Exception e) {
            e.printStackTrace();
            return new Termin(); // or another default value
        }
    }

    @Override
    public Termin saveTermin(Termin tr) {
        try {
            // Provera da li predmet postoji
            Predmet predmet = predmetDAO.GetPredmetSingle(tr.getPredmetID());
            if (predmet == null) {
                // Predmet ne postoji, ne mozemo dodati termin
                return new Termin();
            }

            // Provera da li nastavnik postoji
            Nastavnik nastavnik = nastavnikDAO.GetNastavnikSingle(tr.getNastavnikID());
            if (nastavnik == null) {
                // Nastavnik ne postoji, ne mozemo dodati termin
                return new Termin();
            }

            // Provera da li ucionica postoji
            Ucionica ucionica = ucionicaDAO.GetUcionicaSingle(tr.getUcionicaID());
            if (ucionica == null) {
                // Ucionica ne postoji, ne mozemo dodati termin
                return new Termin();
            }

            // Provera da li grupa postoji
            Grupa grupa = grupaDAO.GetGrupaSingle(tr.getGrupaID());
            if (grupa == null) {
                // Grupa ne postoji, ne mozemo dodati termin
                return new Termin();
            }

            String predmetiString = nastavnik.getPredmeti();
            List<Integer> predmetIds = Arrays.stream(predmetiString.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Session currentSession = entityManager.unwrap(Session.class);
            // Provera da li nastavnik predaje taj predmet
            if (!predmetIds.contains(predmet.getId())) {
                if(predmetIds.stream().count() > 0) {
                    nastavnik.setPredmeti(nastavnik.getPredmeti().concat((",").concat(String.valueOf(tr.getPredmetID()))));
                }
                else {
                    nastavnik.setPredmeti(nastavnik.getPredmeti().concat(String.valueOf(tr.getPredmetID())));
                }
                nastavnikDAO.saveNastavnik(nastavnik);
            }

            // Nastavi sa čuvanjem termina
            currentSession.saveOrUpdate(tr);
            currentSession.flush();
            currentSession.refresh(tr);

            // Ovde možeš dodati dodatnu logiku ili obradu nakon što je termin sačuvan

            return tr;
        } catch (Exception e) {
            e.printStackTrace();
            return new Termin();
        }
    }

    @Override
    public Boolean deleteTermin(int id) {
        try{
            Session currentSession = entityManager.unwrap(Session.class);
            Termin termToDelete = currentSession.get(Termin.class, id);
            // Check if the Tester exists
            if (termToDelete != null) {
                // Delete the Tester
                currentSession.remove(termToDelete);
                return true; // Deletion successful
            } else {
                return false; // Tester with the given ID not found
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately
            return false; // Deletion failed
        }
    }
}
