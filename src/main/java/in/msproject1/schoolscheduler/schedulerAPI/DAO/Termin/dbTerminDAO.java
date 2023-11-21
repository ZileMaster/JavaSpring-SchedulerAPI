package in.msproject1.schoolscheduler.schedulerAPI.DAO.Termin;

import in.msproject1.schoolscheduler.schedulerAPI.model.Termin;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class dbTerminDAO implements ITerminDAO{

    @Autowired
    private EntityManager entityManager;
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
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.saveOrUpdate(tr);
            currentSession.flush();
            currentSession.refresh(tr);
            //flush - refresh to update the object with the new ID
            return tr;
        }catch (Exception e){
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
