package in.msproject1.schoolscheduler.schedulerAPI.DAO.Grupa;

import in.msproject1.schoolscheduler.schedulerAPI.model.Grupa;
import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik;

import java.util.List;

public interface IGrupaDAO {
    List<Grupa> GetGrupaAll();

    Nastavnik GetGrupaSingle(int id);

    Nastavnik saveGrupa(Grupa tr);

    Boolean deleteGrupa(int id);
}
