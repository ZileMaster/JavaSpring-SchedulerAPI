package in.msproject1.schoolscheduler.schedulerAPI.service.Ucionica;

import in.msproject1.schoolscheduler.schedulerAPI.DAO.Ucionica.IUcionicaDAO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Ucionica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UcionicaService implements IUcionicaService{

    @Autowired
    private IUcionicaDAO ucionicaDAO;

    @Transactional
    @Override
    public List<Ucionica> GetUcionicaTables() {
        try {
            return ucionicaDAO.GetUcionicaAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Ucionica GetUcionica(int id) {
        try {
            return ucionicaDAO.GetUcionicaSingle(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Ucionica saveUcionica(Ucionica uc) {
        try {
            return ucionicaDAO.saveUcionica(uc);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Boolean deleteUcionica(int id) {
        try {
            return ucionicaDAO.deleteUcionica(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Ucionica updateUcionica(Ucionica uc) {
        try {
            return ucionicaDAO.saveUcionica(uc);
        } catch (Exception e) {
            throw e;
        }
    }
}
