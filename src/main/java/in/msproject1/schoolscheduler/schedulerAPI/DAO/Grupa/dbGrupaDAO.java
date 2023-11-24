package in.msproject1.schoolscheduler.schedulerAPI.DAO.Grupa;

import in.msproject1.schoolscheduler.schedulerAPI.model.Grupa;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class dbGrupaDAO implements IGrupaDAO{

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
            return Collections.emptyList();
        }
    }

    @Override
    public Grupa GetGrupaSingle(int id) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Grupa> query = currentSession.createQuery("from Grupa where id = :id", Grupa.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }catch (Exception e) {
            e.printStackTrace();
            return new Grupa();
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
    }

    @Override
    public Boolean deleteGrupa(int id) {
        try{
            Session currentSession = entityManager.unwrap(Session.class);
            Grupa groupToDelete = currentSession.get(Grupa.class, id);
            if (groupToDelete != null) {
                currentSession.remove(groupToDelete);
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
    public Grupa getGrupaByNum(int num) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Grupa> query = currentSession.createQuery("from Grupa where grupa = :br", Grupa.class);
            query.setParameter("br", num);
            return query.uniqueResult();
        }catch (Exception e) {
            e.printStackTrace();
            return new Grupa();
        }
    }
}
