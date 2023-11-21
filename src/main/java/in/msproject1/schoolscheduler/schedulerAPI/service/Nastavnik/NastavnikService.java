package in.msproject1.schoolscheduler.schedulerAPI.service.Nastavnik;

import in.msproject1.schoolscheduler.schedulerAPI.DAO.Nastavnik.INastavnikDAO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NastavnikService implements INastavnikService{

    @Autowired
    private INastavnikDAO nastavnikDAO;

    @Transactional
    @Override
    public List<Nastavnik> GetNastavnikTables() {
        try {
            return nastavnikDAO.GetNastavnikAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Nastavnik GetNastavnik(int id) {
        try {
            return nastavnikDAO.GetNastavnikSingle(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Nastavnik saveNastavnik(Nastavnik nast) {

        try {
            return nastavnikDAO.saveNastavnik(nast);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Boolean deleteNastavnik(int id) {
        try {
            return nastavnikDAO.deleteNastavnik(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Nastavnik updateNastavnik(Nastavnik nast) {
        try {
            return nastavnikDAO.saveNastavnik(nast);
        } catch (Exception e) {
            throw e;
        }
    }
}
