package in.msproject1.schoolscheduler.schedulerAPI.DAO.Predmet;

import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet.Predmet;
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
            return Collections.emptyList();
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
            return new Predmet();
        }
    }

    @Override
    public Predmet savePredmet(Predmet pred) {
        try {
            if (pred.getESPB() == 0)
            {
                pred.setESPB(6);
            }

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
            if (prToDelete != null) {
                currentSession.remove(prToDelete);
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
    public Predmet getPredmetByName(String naziv) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Predmet> query = currentSession.createQuery("from Predmet where naziv = :naziv", Predmet.class);
            query.setParameter("naziv", naziv);
            return query.uniqueResult();
        }catch (Exception e) {
            e.printStackTrace();
            return new Predmet();
        }
    }
}
