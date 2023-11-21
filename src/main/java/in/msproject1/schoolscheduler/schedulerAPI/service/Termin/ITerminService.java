package in.msproject1.schoolscheduler.schedulerAPI.service.Termin;

import in.msproject1.schoolscheduler.schedulerAPI.model.Termin;
import in.msproject1.schoolscheduler.schedulerAPI.model.Tester;

import java.util.List;

public interface ITerminService {
    List<Termin> GetTerminTables();

    Termin GetTermin(int id);

    Termin saveTermin(Termin tr);

    Boolean deleteTermin(int id);

    Termin updateTermin(Termin tr);
}
