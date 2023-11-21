package in.msproject1.schoolscheduler.schedulerAPI.DAO.Ucionica;

import in.msproject1.schoolscheduler.schedulerAPI.model.Ucionica;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class dbUcionicaDAO implements IUcionicaDAO{

    @Override
    public List<Ucionica> GetUcionicaAll() {
        return null;
    }

    @Override
    public Ucionica GetUcionicaSingle(int id) {
        return null;
    }

    @Override
    public Ucionica saveUcionica(Ucionica uc) {
        return null;
    }

    @Override
    public Boolean deleteUcionica(int id) {
        return null;
    }
}
