package in.msproject1.schoolscheduler.schedulerAPI.DAO.Nastavnik;

import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik.Nastavnik;

import java.util.List;

public interface INastavnikDAO {
    List<Nastavnik> GetNastavnikAll();

    Nastavnik GetNastavnikSingle(int id);

    Nastavnik saveNastavnik(Nastavnik tr);

    Boolean deleteNastavnik(int id);

    Object GetNastavnikCustom(String ime, String prezime);
}
