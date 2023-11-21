package in.msproject1.schoolscheduler.schedulerAPI.DAO.Ucionica;

<<<<<<< HEAD
import in.msproject1.schoolscheduler.schedulerAPI.model.Ucionica;
import org.springframework.stereotype.Repository;

=======
import in.msproject1.schoolscheduler.schedulerAPI.model.Tester;
import in.msproject1.schoolscheduler.schedulerAPI.model.Ucionica;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
>>>>>>> 2cc3cced8c85b5d7f893ea6863adeb5057370878
import java.util.List;

@Repository
public class dbUcionicaDAO implements IUcionicaDAO{

<<<<<<< HEAD
    @Override
    public List<Ucionica> GetUcionicaAll() {
        return null;
=======
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Ucionica> GetUcionicaAll() {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Ucionica> query = currentSession.createQuery("from Ucionica", Ucionica.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately
            return Collections.emptyList(); // or another default value
        }
>>>>>>> 2cc3cced8c85b5d7f893ea6863adeb5057370878
    }

    @Override
    public Ucionica GetUcionicaSingle(int id) {
<<<<<<< HEAD
        return null;
=======
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Ucionica> query = currentSession.createQuery("from Ucionica where id = :id", Ucionica.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }catch (Exception e) {
            e.printStackTrace();
            return new Ucionica(); // or another default value
        }
>>>>>>> 2cc3cced8c85b5d7f893ea6863adeb5057370878
    }

    @Override
    public Ucionica saveUcionica(Ucionica uc) {
<<<<<<< HEAD
        return null;
=======
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.saveOrUpdate(uc);
            currentSession.flush();
            currentSession.refresh(uc);
            //flush - refresh to update the object with the new ID
            return uc;
        }catch (Exception e){
            e.printStackTrace();
            return new Ucionica();
        }
>>>>>>> 2cc3cced8c85b5d7f893ea6863adeb5057370878
    }

    @Override
    public Boolean deleteUcionica(int id) {
<<<<<<< HEAD
        return null;
=======
        try{
            Session currentSession = entityManager.unwrap(Session.class);
            Ucionica ucionicaToDelete = currentSession.get(Ucionica.class, id);
            // Check if the Tester exists
            if (ucionicaToDelete != null) {
                // Delete the Tester
                currentSession.remove(ucionicaToDelete);
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
