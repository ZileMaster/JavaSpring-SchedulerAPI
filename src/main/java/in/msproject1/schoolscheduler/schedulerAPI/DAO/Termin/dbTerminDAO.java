package in.msproject1.schoolscheduler.schedulerAPI.DAO.Termin;

import in.msproject1.schoolscheduler.schedulerAPI.model.Termin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class dbTerminDAO implements ITerminDAO{
    @Override
    public List<Termin> GetTerminAll() {
        return null;
    }

    @Override
    public Termin GetTerminSingle(int id) {
        return null;
    }

    @Override
    public Termin saveTermin(Termin tr) {
        return null;
    }

    @Override
    public Boolean deleteTermin(int id) {
        return null;
    }
}
