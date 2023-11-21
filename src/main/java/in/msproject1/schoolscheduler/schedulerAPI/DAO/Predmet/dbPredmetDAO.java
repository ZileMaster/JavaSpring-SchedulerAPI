package in.msproject1.schoolscheduler.schedulerAPI.DAO.Predmet;

import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class dbPredmetDAO implements IPredmetDAO{
    @Override
    public List<Predmet> GetPredmetAll() {
        return null;
    }

    @Override
    public Predmet GetPredmetSingle(int id) {
        return null;
    }

    @Override
    public Predmet savePredmet(Predmet tr) {
        return null;
    }

    @Override
    public Boolean deletePredmet(int id) {
        return null;
    }
}
