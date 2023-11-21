package in.msproject1.schoolscheduler.schedulerAPI.service.Nastavnik;

import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NastavnikService implements INastavnikService{
    @Override
    public List<Nastavnik> GetNastavnikTables() {
        return null;
    }

    @Override
    public Nastavnik GetNastavnik(int id) {
        return null;
    }

    @Override
    public Nastavnik saveNastavnik(Nastavnik nast) {
        return null;
    }

    @Override
    public Boolean deleteNastavnik(int id) {
        return null;
    }

    @Override
    public Nastavnik updateNastavnik(Nastavnik nast) {
        return null;
    }
}
