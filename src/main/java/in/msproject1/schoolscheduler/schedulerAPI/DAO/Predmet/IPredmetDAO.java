package in.msproject1.schoolscheduler.schedulerAPI.DAO.Predmet;

import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet.Predmet;

import java.util.List;

public interface IPredmetDAO {
    List<Predmet> GetPredmetAll();

    Predmet GetPredmetSingle(int id);

    Predmet savePredmet(Predmet tr);

    Boolean deletePredmet(int id);
}
