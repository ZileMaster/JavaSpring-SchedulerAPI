package in.msproject1.schoolscheduler.schedulerAPI.DAO.Nastavnik;

import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

=======
import in.msproject1.schoolscheduler.schedulerAPI.model.Tester;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
>>>>>>> 2cc3cced8c85b5d7f893ea6863adeb5057370878
import java.util.List;

@Repository
public class dbNastavnikDAO implements INastavnikDAO{

<<<<<<< HEAD
    @Override
    public List<Nastavnik> GetNastavnikAll() {
        return null;
=======
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Nastavnik> GetNastavnikAll() {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Nastavnik> query = currentSession.createQuery("from Nastavnik ", Nastavnik.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately
            return Collections.emptyList(); // or another default value
        }
>>>>>>> 2cc3cced8c85b5d7f893ea6863adeb5057370878
    }

    @Override
    public Nastavnik GetNastavnikSingle(int id) {
<<<<<<< HEAD
        return null;
    }

    @Override
    public Nastavnik saveNastavnik(Nastavnik tr) {
        return null;
=======
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Nastavnik> query = currentSession.createQuery("from Nastavnik where id = :id", Nastavnik.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }catch (Exception e) {
            e.printStackTrace();
            return new Nastavnik(); // or another default value
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
        }catch (Exception e){
            e.printStackTrace();
            return new Nastavnik();
        }
>>>>>>> 2cc3cced8c85b5d7f893ea6863adeb5057370878
    }

    @Override
    public Boolean deleteNastavnik(int id) {
<<<<<<< HEAD
        return null;
=======
        try{
            Session currentSession = entityManager.unwrap(Session.class);
            Nastavnik nastToDelete = currentSession.get(Nastavnik.class, id);
            // Check if the Tester exists
            if (nastToDelete != null) {
                // Delete the Tester
                currentSession.remove(nastToDelete);
                return true; // Deletion successful
            } else {
                return false; // Tester with the given ID not found
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately
            return false; // Deletion failed
        }
>>>>>>> 2cc3cced8c85b5d7f893ea6863adeb5057370878
    }
}
