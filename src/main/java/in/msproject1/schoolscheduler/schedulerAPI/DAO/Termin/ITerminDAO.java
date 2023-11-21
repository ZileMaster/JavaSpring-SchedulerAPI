package in.msproject1.schoolscheduler.schedulerAPI.DAO.Termin;

import in.msproject1.schoolscheduler.schedulerAPI.model.Termin;
import in.msproject1.schoolscheduler.schedulerAPI.model.Ucionica;

import java.util.List;

public interface ITerminDAO {
    List<Termin> GetTerminAll();

    Termin GetTerminSingle(int id);

    Termin saveTermin(Termin tr);

    Boolean deleteTermin(int id);
}
