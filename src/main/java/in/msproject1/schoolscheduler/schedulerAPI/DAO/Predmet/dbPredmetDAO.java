package in.msproject1.schoolscheduler.schedulerAPI.DAO.Predmet;

import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet;
import in.msproject1.schoolscheduler.schedulerAPI.model.Tester;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class dbPredmetDAO implements IPredmetDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Predmet> GetPredmetAll() {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Predmet> query = currentSession.createQuery("from Predmet", Predmet.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately
            return Collections.emptyList(); // or another default value
        }
    }

    @Override
    public Predmet GetPredmetSingle(int id) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Predmet> query = currentSession.createQuery("from Predmet where id = :id", Predmet.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }catch (Exception e) {
            e.printStackTrace();
            return new Predmet(); // or another default value
        }
    }

    @Override
    public Predmet savePredmet(Predmet pred) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.saveOrUpdate(pred);
            currentSession.flush();
            currentSession.refresh(pred);
            //flush - refresh to update the object with the new ID
            return pred;
        }catch (Exception e){
            e.printStackTrace();
            return new Predmet();
        }
    }

    @Override
    public Boolean deletePredmet(int id) {
        try{
            Session currentSession = entityManager.unwrap(Session.class);
            Predmet prToDelete = currentSession.get(Predmet.class, id);
            // Check if the Tester exists
            if (prToDelete != null) {
                // Delete the Tester
                currentSession.remove(prToDelete);
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
