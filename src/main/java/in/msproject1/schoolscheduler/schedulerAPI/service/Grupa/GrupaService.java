package in.msproject1.schoolscheduler.schedulerAPI.service.Grupa;

import in.msproject1.schoolscheduler.schedulerAPI.DAO.Grupa.IGrupaDAO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Grupa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupaService implements IGrupaService{

    @Autowired
    private IGrupaDAO grupaDAO;

    @Override
    public List<Grupa> GetGrupaTables() {
        try{
            return grupaDAO.GetGrupaAll();
        }catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public Grupa GetGrupa(int id) {
        try{
            return grupaDAO.GetGrupaSingle(id);
        }catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public Grupa saveGrupa(Grupa gr) {
        try{
            return grupaDAO.saveGrupa(gr);
        }catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public Boolean deleteGrupa(int id) {
        try{
            return grupaDAO.deleteGrupa(id);
        }catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public Grupa updateGrupa(Grupa gr) {
        try{
            return grupaDAO.saveGrupa(gr);
        }catch (Exception e)
        {
            throw e;
        }
    }
}
