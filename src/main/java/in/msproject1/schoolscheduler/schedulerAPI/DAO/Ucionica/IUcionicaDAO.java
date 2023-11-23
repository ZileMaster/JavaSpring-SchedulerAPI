package in.msproject1.schoolscheduler.schedulerAPI.DAO.Ucionica;

import in.msproject1.schoolscheduler.schedulerAPI.model.Tester;
import in.msproject1.schoolscheduler.schedulerAPI.model.Ucionica;

import java.util.List;

public interface IUcionicaDAO {
    List<Ucionica> GetUcionicaAll();

    Ucionica GetUcionicaSingle(int id);

    Ucionica saveUcionica(Ucionica uc);

    Boolean deleteUcionica(int id);

    List<Ucionica> GetUcionicaByIsPC(Boolean parametar);
}
