package in.msproject1.schoolscheduler.schedulerAPI.service.Predmet;

import in.msproject1.schoolscheduler.schedulerAPI.DAO.Predmet.IPredmetDAO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet.Predmet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PredmetService implements IPredmetService{

    @Autowired
    private IPredmetDAO predmetDAO;

    @Transactional
    @Override
    public List<Predmet> GetPredmetTables() {
        try {
            return predmetDAO.GetPredmetAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Predmet GetPredmet(int id) {
        try {
            return predmetDAO.GetPredmetSingle(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Predmet savePredmet(Predmet pred) {
        try {
            return predmetDAO.savePredmet(pred);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Boolean deletePredmet(int id) {
        try {
            return predmetDAO.deletePredmet(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Predmet updatePredmet(Predmet pred) {
        try {
            return predmetDAO.savePredmet(pred);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Predmet getPredmetByName(String naziv) {
        try {
            return predmetDAO.getPredmetByName(naziv);
        } catch (Exception e) {
            throw e;
        }
    }
}
