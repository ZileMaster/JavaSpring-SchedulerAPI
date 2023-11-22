package in.msproject1.schoolscheduler.schedulerAPI.service.Nastavnik;

import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik.Nastavnik;

import java.util.List;

public interface INastavnikService {
    List<Nastavnik> GetNastavnikTables();

    Nastavnik GetNastavnik(int id);

    Nastavnik saveNastavnik(Nastavnik nast);

    Boolean deleteNastavnik(int id);

    Nastavnik updateNastavnik(Nastavnik nast);

    Object GetNastavnikCustom(String ime, String prezime);
}
