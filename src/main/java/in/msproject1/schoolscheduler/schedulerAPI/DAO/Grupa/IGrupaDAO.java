package in.msproject1.schoolscheduler.schedulerAPI.DAO.Grupa;

import in.msproject1.schoolscheduler.schedulerAPI.model.Grupa;

import java.util.List;

public interface IGrupaDAO {
    List<Grupa> GetGrupaAll();

    Grupa GetGrupaSingle(int id);

    Grupa saveGrupa(Grupa tr);

    Boolean deleteGrupa(int id);

    Grupa getGrupaByNum(int num);
}
