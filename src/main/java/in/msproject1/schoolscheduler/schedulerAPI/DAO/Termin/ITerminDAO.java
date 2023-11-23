package in.msproject1.schoolscheduler.schedulerAPI.DAO.Termin;

import in.msproject1.schoolscheduler.schedulerAPI.model.Termin.Termin;
import in.msproject1.schoolscheduler.schedulerAPI.model.Termin.TerminDTO;

import java.util.List;

public interface ITerminDAO {
    List<Termin> GetTerminAll();

    Termin GetTerminSingle(int id);

    Termin saveTermin(Termin tr);

    Boolean deleteTermin(int id);

    Boolean deleteTerminByParameters(int vreme, int ucionica, String dan);

    List<Termin> GetTerminsSorted(int firstParam, int secondParam);

    List<TerminDTO> GetTerminsByDayAndUcionica(String day, int ucionicaID);
}
