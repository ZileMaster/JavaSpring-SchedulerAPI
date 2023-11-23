package in.msproject1.schoolscheduler.schedulerAPI.service.Termin;

import in.msproject1.schoolscheduler.schedulerAPI.DAO.Termin.ITerminDAO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Termin.Termin;
import in.msproject1.schoolscheduler.schedulerAPI.model.Termin.TerminDTO;
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

    @Override
    public Boolean deleteTerminByParameters(int vreme, int ucionica, String dan) {
        if (vreme < 0 || ucionica < 1 || dan.length() < 3)
        {
            return false;
        }

        try {
            return terminDAO.deleteTerminByParameters(vreme, ucionica, dan);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Termin> GetTerminSorted(int firstParam, int secondParam) {
        try {
            return terminDAO.GetTerminsSorted(firstParam, secondParam);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<TerminDTO> GetTerminsByDayAndUcionica(String day, int ucionicaID) {
        try {
            return terminDAO.GetTerminsByDayAndUcionica(day, ucionicaID);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<TerminDTO> GetTerminsByGroup(int groupID) {
        try {
            return terminDAO.GetTerminsByGroup(groupID);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<TerminDTO> GetTerminsByNastavnik(int nastavnikID) {
        try {
            return terminDAO.GetTerminsByNastavnik(nastavnikID);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<TerminDTO> GetTerminsByPredmetID(int predmetID) {
        try {
            return terminDAO.GetTerminsByPredmet(predmetID);
        } catch (Exception e) {
            throw e;
        }
    }
}
