package in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik;

import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet.Predmet;

import java.util.List;

public class NastavnikDTO {
    private int id;
    private String ime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String prezime;

    private List<Predmet> predmet;

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

    public List<Predmet> getPredmet() {
        return predmet;
    }

    public void setPredmet(List<Predmet> predmet) {
        this.predmet = predmet;
    }
}

