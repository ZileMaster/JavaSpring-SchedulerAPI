package in.msproject1.schoolscheduler.schedulerAPI.service.Termin;

import in.msproject1.schoolscheduler.schedulerAPI.model.Termin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminService implements ITerminService{
    @Override
    public List<Termin> GetTerminTables() {
        return null;
    }

    @Override
    public Termin GetTermin(int id) {
        return null;
    }

    @Override
    public Termin saveTermin(Termin tr) {
        return null;
    }

    @Override
    public Boolean deleteTermin(int id) {
        return null;
    }

    @Override
    public Termin updateTermin(Termin tr) {
        return null;
    }
}
