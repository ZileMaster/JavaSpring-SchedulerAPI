package in.msproject1.schoolscheduler.schedulerAPI.DAO.Tester;

import in.msproject1.schoolscheduler.schedulerAPI.model.Tester;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


@Repository
public class TesterDAOimplementation implements ITesterDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Tester> GetTesterTables() {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Tester> query = currentSession.createQuery("from Tester", Tester.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately
            return Collections.emptyList(); // or another default value
        }
    }

    @Override
    public Tester GetSingle(int id) {

        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Tester> query = currentSession.createQuery("from Tester where id = :id", Tester.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }catch (Exception e) {
            e.printStackTrace();
            return new Tester(); // or another default value
        }

    }


    @Override
    public Tester save(Tester test) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.saveOrUpdate(test);
            currentSession.flush();
            currentSession.refresh(test);
            //flush - refresh to update the object with the new ID
            return test;
        }catch (Exception e){
            e.printStackTrace();
            return new Tester();
        }
    }

    @Override
    public Boolean delete(int id) {
        try{
            Session currentSession = entityManager.unwrap(Session.class);
            Tester testToDelete = currentSession.get(Tester.class, id);
            // Check if the Tester exists
            if (testToDelete != null) {
                // Delete the Tester
                currentSession.remove(testToDelete);
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

//Dead code that is commented out because i resolved the update in the post
//    @Override
//    public Tester updateTest(Tester test) {
//        try {
//            Session currentSession = entityManager.unwrap(Session.class);
//
//            // Check if the Tester with the given ID exists
//            Tester existingTester = currentSession.get(Tester.class, test.getId());
//
//            if (existingTester != null) {
//                // Update the properties of the existing Tester with the new values
//                existingTester.setName(test.getName());
//                existingTester.setCountry(test.getCountry());
//                existingTester.setPersonalDescription(test.getPersonalDescription());
//
//                // Save or update the modified Tester
//                currentSession.update(existingTester);
//
//                return existingTester; // Return the updated Tester
//            } else {
//                // Tester with the given ID not found
//                return null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Handle the exception appropriately
//            return null; // Update failed
//        }
//    }


}
