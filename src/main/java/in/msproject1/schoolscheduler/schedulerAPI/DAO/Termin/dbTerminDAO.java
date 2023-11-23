package in.msproject1.schoolscheduler.schedulerAPI.DAO.Termin;

import in.msproject1.schoolscheduler.schedulerAPI.DAO.Grupa.IGrupaDAO;
import in.msproject1.schoolscheduler.schedulerAPI.DAO.Nastavnik.INastavnikDAO;
import in.msproject1.schoolscheduler.schedulerAPI.DAO.Predmet.IPredmetDAO;
import in.msproject1.schoolscheduler.schedulerAPI.DAO.Ucionica.IUcionicaDAO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Grupa;
import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik.Nastavnik;
import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet.Predmet;
import in.msproject1.schoolscheduler.schedulerAPI.model.Termin.Termin;
import in.msproject1.schoolscheduler.schedulerAPI.model.Termin.TerminDTO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Ucionica;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
            return Collections.emptyList();
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
            return new Termin();
        }
    }

    @Override
    public Termin saveTermin(Termin tr) {
        try {
            Predmet predmet = predmetDAO.GetPredmetSingle(tr.getPredmetID());
            if (predmet == null) {
                // Predmet ne postoji, ne mozemo dodati termin
                return new Termin();
            }

            Nastavnik nastavnik = nastavnikDAO.GetNastavnikSingle(tr.getNastavnikID());
            if (nastavnik == null) {
                // Nastavnik ne postoji, ne mozemo dodati termin
                return new Termin();
            }

            Ucionica ucionica = ucionicaDAO.GetUcionicaSingle(tr.getUcionicaID());
            if (ucionica == null) {
                // Ucionica ne postoji, ne mozemo dodati termin
                return new Termin();
            }

            Grupa grupa = grupaDAO.GetGrupaSingle(tr.getGrupaID());
            if (grupa == null) {
                // Grupa ne postoji, ne mozemo dodati termin
                return new Termin();
            }
            List<Integer> predmetIds = new ArrayList<>();
            String predmetiString = nastavnik.getPredmeti();
            if(!predmetiString.isEmpty()) {
                predmetIds = Arrays.stream(predmetiString.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            }

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
            if (termToDelete != null) {
                currentSession.remove(termToDelete);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteTerminByParameters(int vreme, int ucionica, String dan) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            // Query to find the Termin based on vreme, ucionica, and dan
            Query<Termin> query = currentSession.createQuery(
                    "from Termin where startTime = :vreme and ucionicaID = :ucionica and day = :dan", Termin.class);
            query.setParameter("vreme", vreme);
            query.setParameter("ucionica", ucionica);
            query.setParameter("dan", dan);

            Termin termToDelete = query.uniqueResult();

            // Check if the Termin exists
            if (termToDelete != null) {
                currentSession.remove(termToDelete);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Termin> GetTerminsSorted(int firstParam, int secondParam) {
        //first param tels me if it's by Ucionica, day, time of start, and the second one tells me if it's desc or asc.

        try {
        Session currentSession = entityManager.unwrap(Session.class);

        String queryString = "FROM Termin t ";

            switch (firstParam) {
                case 1:
                    queryString += " JOIN Ucionica u on t.ucionicaID = u.ucionicaID ORDER BY u.broj";
                    break;
                case 2:
                    // Order by day and then by startTime
                    queryString += "ORDER BY CASE t.day "
                            + "WHEN 'Monday' THEN 1 "
                            + "WHEN 'Tusday' THEN 2 "
                            + "WHEN 'Wednesday' THEN 3 "
                            + "WHEN 'Thursday' THEN 4 "
                            + "WHEN 'Friday' THEN 5 "
                            + "ELSE 6 END, t.startTime";
                    break;
                // Add more cases for other parameters as needed
                default:
                    // Handle invalid firstParam value or provide a default sorting strategy
                    break;
            }

        queryString += (secondParam == 2 ? " DESC" : " ASC");

        Query<Termin> query = currentSession.createQuery(queryString, Termin.class);

        return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<TerminDTO> GetTerminsByDayAndUcionica(String day, int ucionicaID) {
        return null;
    }
}
