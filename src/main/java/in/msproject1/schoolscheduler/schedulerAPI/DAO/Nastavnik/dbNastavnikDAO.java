package in.msproject1.schoolscheduler.schedulerAPI.DAO.Nastavnik;

import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class dbNastavnikDAO implements INastavnikDAO{

    @Override
    public List<Nastavnik> GetNastavnikAll() {
        return null;
    }

    @Override
    public Nastavnik GetNastavnikSingle(int id) {
        return null;
    }

    @Override
    public Nastavnik saveNastavnik(Nastavnik tr) {
        return null;
    }

    @Override
    public Boolean deleteNastavnik(int id) {
        return null;
    }
}
