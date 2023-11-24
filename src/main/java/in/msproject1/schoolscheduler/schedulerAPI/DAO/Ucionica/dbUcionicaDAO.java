package in.msproject1.schoolscheduler.schedulerAPI.DAO.Ucionica;

import in.msproject1.schoolscheduler.schedulerAPI.model.Ucionica;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class dbUcionicaDAO implements IUcionicaDAO{

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
                return Collections.emptyList();
            }
    }

    @Override
    public Ucionica GetUcionicaSingle(int id) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Ucionica> query = currentSession.createQuery("from Ucionica where id = :id", Ucionica.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }catch (Exception e) {
            e.printStackTrace();
            return new Ucionica();
        }
    }

    @Override
    public Ucionica saveUcionica(Ucionica uc) {
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
    }

    @Override
    public Boolean deleteUcionica(int id) {
        try{
            Session currentSession = entityManager.unwrap(Session.class);
            Ucionica ucionicaToDelete = currentSession.get(Ucionica.class, id);
            if (ucionicaToDelete != null) {
                currentSession.remove(ucionicaToDelete);
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
    public List<Ucionica> GetUcionicaByIsPC(Boolean parametar) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Ucionica> query = currentSession.createQuery("from Ucionica where isPC = :parametar", Ucionica.class);
            query.setParameter("parametar", parametar);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Ucionica GetUcionicaByNumber(int numClassRoom) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            Query<Ucionica> query = currentSession.createQuery("from Ucionica where broj = :numClassRoom", Ucionica.class);
            query.setParameter("numClassRoom", numClassRoom);
            return query.uniqueResult();
        }catch (Exception e) {
            e.printStackTrace();
            return new Ucionica();
        }
    }
}
