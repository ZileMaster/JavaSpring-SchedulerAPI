package in.msproject1.schoolscheduler.schedulerAPI.service.Ucionica;

import in.msproject1.schoolscheduler.schedulerAPI.DAO.Ucionica.IUcionicaDAO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Tester;
import in.msproject1.schoolscheduler.schedulerAPI.model.Ucionica;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IUcionicaService {
    List<Ucionica> GetUcionicaTables();

    Ucionica GetUcionica(int id);

    Ucionica saveUcionica(Ucionica uc);

    Boolean deleteUcionica(int id);

    Ucionica updateUcionica(Ucionica uc);

    List<Ucionica> GetUcionicaCustom(Boolean parametar);
}
