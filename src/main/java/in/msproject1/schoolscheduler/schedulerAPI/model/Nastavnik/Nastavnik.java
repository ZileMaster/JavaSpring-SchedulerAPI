package in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik;

import jakarta.persistence.*;

@Entity
@Table(name = "nastavnik")
public class Nastavnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int nastavnikID;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private String Zvanje;

    @Column
    private String predmeti;

    public int getNastavnikID() {
        return nastavnikID;
    }

    public void setNastavnikID(int nastavnikID) {
        this.nastavnikID = nastavnikID;
    }

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

    public String getZvanje() {
        return Zvanje;
    }

    public void setZvanje(String zvanje) {
        Zvanje = zvanje;
    }

    public String getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(String predmeti) {
        this.predmeti = predmeti;
    }

    @Override
    public String toString() {
        return "Nastavnik{" +
                "nastavnikID=" + nastavnikID +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", Zvanje='" + Zvanje + '\'' +
                ", predmeti=" + predmeti +
                '}';
    }
}
