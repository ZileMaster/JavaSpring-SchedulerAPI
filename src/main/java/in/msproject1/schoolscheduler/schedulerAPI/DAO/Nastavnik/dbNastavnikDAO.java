package in.msproject1.schoolscheduler.schedulerAPI.DAO.Nastavnik;

import in.msproject1.schoolscheduler.schedulerAPI.DAO.Predmet.IPredmetDAO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik.Nastavnik;
import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik.NastavnikDTO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet.Predmet;
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
public class dbNastavnikDAO implements INastavnikDAO {

    @Autowired
    private EntityManager entityManager;

    //little dependency injection
    @Autowired
    private IPredmetDAO predmetDAO;

    @Override
    public List<Nastavnik> GetNastavnikAll() {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Nastavnik> query = currentSession.createQuery("from Nastavnik ", Nastavnik.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Nastavnik GetNastavnikSingle(int id) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Nastavnik> query = currentSession.createQuery("from Nastavnik where id = :id", Nastavnik.class);
            query.setParameter("id", id);
            return (Nastavnik) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return (Nastavnik) new Nastavnik();
        }
    }

    @Override
    public Nastavnik saveNastavnik(Nastavnik nast) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.saveOrUpdate(nast);
            currentSession.flush();
            currentSession.refresh(nast);
            //flush - refresh to update the object with the new ID
            return nast;
        } catch (Exception e) {
            e.printStackTrace();
            return new Nastavnik();
        }
    }

    @Override
    public Boolean deleteNastavnik(int id) {
        try{
            Session currentSession = entityManager.unwrap(Session.class);
            Nastavnik nastToDelete = currentSession.get(Nastavnik.class, id);

            if (nastToDelete != null) {
                currentSession.remove(nastToDelete);
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
    public NastavnikDTO GetNastavnikCustom(String ime, String prezime) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Nastavnik> query = currentSession.createQuery("from Nastavnik where ime = :ime and prezime = :prezime", Nastavnik.class);
            query.setParameter("ime", ime);
            query.setParameter("prezime", prezime);
            Nastavnik nastavnik = query.uniqueResult();

            NastavnikDTO retval = new NastavnikDTO();

            if (nastavnik != null) {
                String predmetiString = nastavnik.getPredmeti();
                List<Integer> predmetIds = Arrays.stream(predmetiString.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                retval.setIme(nastavnik.getIme());
                retval.setPrezime(nastavnik.getPrezime());
                retval.setId(nastavnik.getNastavnikID());

                List<Predmet> predmeti = new ArrayList<>();
                for ( int num : predmetIds) {
                    Predmet pred = predmetDAO.GetPredmetSingle(num);
                    predmeti.add(pred);
                }

                retval.setPredmet(predmeti);

                return retval;
            } else {

                return new NastavnikDTO();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new NastavnikDTO();
        }
    }
}
