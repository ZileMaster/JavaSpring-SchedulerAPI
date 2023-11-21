package in.msproject1.schoolscheduler.schedulerAPI.service.Termin;

import in.msproject1.schoolscheduler.schedulerAPI.DAO.Termin.ITerminDAO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Termin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TerminService implements ITerminService{

    @Autowired
    ITerminDAO terminDAO;

    @Transactional
    @Override
    public List<Termin> GetTerminTables() {
        try {
            return terminDAO.GetTerminAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Termin GetTermin(int id) {
        try {
            return terminDAO.GetTerminSingle(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Termin saveTermin(Termin tr) {
        try {
            return terminDAO.saveTermin(tr);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Boolean deleteTermin(int id) {
        try {
            return terminDAO.deleteTermin(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Termin updateTermin(Termin tr) {
        try {
            return terminDAO.saveTermin(tr);
        } catch (Exception e) {
            throw e;
        }
    }
}
