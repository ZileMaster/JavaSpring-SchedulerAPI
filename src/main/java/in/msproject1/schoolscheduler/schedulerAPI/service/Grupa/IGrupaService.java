package in.msproject1.schoolscheduler.schedulerAPI.service.Grupa;

import in.msproject1.schoolscheduler.schedulerAPI.model.Grupa;
import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik;

import java.util.List;

public interface IGrupaService {
    List<Grupa> GetGrupaTables();

    Grupa GetGrupa(int id);

    Grupa saveGrupa(Grupa gr);

    Boolean deleteGrupa(int id);

    Grupa updateGrupa(Grupa gr);
}
