package in.msproject1.schoolscheduler.schedulerAPI.service.Termin;

import in.msproject1.schoolscheduler.schedulerAPI.model.Termin.Termin;
import in.msproject1.schoolscheduler.schedulerAPI.model.Termin.TerminDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ITerminService {
    void InsertStuffByCSV(MultipartFile file);

    List<Termin> GetTerminTables();

    Termin GetTermin(int id);

    Termin saveTermin(Termin tr);

    Boolean deleteTermin(int id);

    Termin updateTermin(Termin tr);

    Boolean deleteTerminByParameters(int vreme, int ucionica, String dan);

    List<Termin> GetTerminSorted(int firstParam, int secondParam);

    List<TerminDTO> GetTerminsByDayAndUcionica(String day, int ucionicaID);

    List<TerminDTO> GetTerminsByGroup(int groupID);

    List<TerminDTO> GetTerminsByNastavnik(int nastavnikID);

    List<TerminDTO> GetTerminsByPredmetID(int predmetID);
}
