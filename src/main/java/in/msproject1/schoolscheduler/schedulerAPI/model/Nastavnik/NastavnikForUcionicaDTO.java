package in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik;

import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet.Predmet;
import in.msproject1.schoolscheduler.schedulerAPI.model.Ucionica;

import java.util.List;

public class NastavnikForUcionicaDTO {
    private String ime;

    private String prezime;

    private List<Ucionica> ucionica;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public List<Ucionica> getUcionica() {
        return ucionica;
    }

    public void setUcionica(List<Ucionica> ucionica) {
        this.ucionica = ucionica;
    }
}
