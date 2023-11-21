package in.msproject1.schoolscheduler.schedulerAPI.DAO.Grupa;

import in.msproject1.schoolscheduler.schedulerAPI.model.Grupa;
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
public class dbGrupaDAO implements IGrupaDAO{

<<<<<<< HEAD

    @Override
    public List<Grupa> GetGrupaAll() {
        return null;
=======
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Grupa> GetGrupaAll() {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Grupa> query = currentSession.createQuery("from Grupa ", Grupa.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately
            return Collections.emptyList(); // or another default value
        }
>>>>>>> 2cc3cced8c85b5d7f893ea6863adeb5057370878
    }

    @Override
    public Grupa GetGrupaSingle(int id) {
<<<<<<< HEAD
        return null;
    }

    @Override
    public Grupa saveGrupa(Grupa tr) {
        return null;
=======
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Grupa> query = currentSession.createQuery("from Grupa where id = :id", Grupa.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }catch (Exception e) {
            e.printStackTrace();
            return new Grupa(); // or another default value
        }
    }

    @Override
    public Grupa saveGrupa(Grupa gr) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.saveOrUpdate(gr);
            currentSession.flush();
            currentSession.refresh(gr);
            //flush - refresh to update the object with the new ID
            return gr;
        }catch (Exception e){
            e.printStackTrace();
            return new Grupa();
        }
>>>>>>> 2cc3cced8c85b5d7f893ea6863adeb5057370878
    }

    @Override
    public Boolean deleteGrupa(int id) {
<<<<<<< HEAD
        return null;
=======
        try{
            Session currentSession = entityManager.unwrap(Session.class);
            Grupa groupToDelete = currentSession.get(Grupa.class, id);
            // Check if the Tester exists
            if (groupToDelete != null) {
                // Delete the Tester
                currentSession.remove(groupToDelete);
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
