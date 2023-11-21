package in.msproject1.schoolscheduler.schedulerAPI.service.Predmet;

import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet;
import in.msproject1.schoolscheduler.schedulerAPI.model.Termin;

import java.util.List;

public interface IPredmetService {
    List<Predmet> GetPredmetTables();

    Predmet GetPredmet(int id);

    Predmet savePredmet(Predmet pred);

    Boolean deletePredmet(int id);

    Predmet updatePredmet(Predmet pred);
}
