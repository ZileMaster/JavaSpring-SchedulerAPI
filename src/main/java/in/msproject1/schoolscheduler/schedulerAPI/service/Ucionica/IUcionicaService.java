package in.msproject1.schoolscheduler.schedulerAPI.service.Ucionica;

import in.msproject1.schoolscheduler.schedulerAPI.model.Tester;
import in.msproject1.schoolscheduler.schedulerAPI.model.Ucionica;

import java.util.List;

public interface IUcionicaService {
    List<Ucionica> GetUcionicaTables();

    Ucionica GetUcionica(int id);

    Ucionica saveUcionica(Ucionica uc);

    Boolean deleteUcionica(int id);

    Ucionica updateUcionica(Ucionica uc);
}
