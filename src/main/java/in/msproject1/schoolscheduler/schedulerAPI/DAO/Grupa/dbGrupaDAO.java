package in.msproject1.schoolscheduler.schedulerAPI.DAO.Grupa;

import in.msproject1.schoolscheduler.schedulerAPI.model.Grupa;
import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class dbGrupaDAO implements IGrupaDAO{


    @Override
    public List<Grupa> GetGrupaAll() {
        return null;
    }

    @Override
    public Nastavnik GetGrupaSingle(int id) {
        return null;
    }

    @Override
    public Nastavnik saveGrupa(Grupa tr) {
        return null;
    }

    @Override
    public Boolean deleteGrupa(int id) {
        return null;
    }
}
