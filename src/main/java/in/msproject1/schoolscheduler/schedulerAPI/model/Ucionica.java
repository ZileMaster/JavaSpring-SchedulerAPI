package in.msproject1.schoolscheduler.schedulerAPI.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Ucionica")
public class Ucionica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int ucionicaID;

    @Column
    private int broj;

    @Column
    private boolean isPC;

    @Column
    private int mesta;

    public int getUcionicaID() {
        return ucionicaID;
    }

    public void setUcionicaID(int ucionicaID) {
        this.ucionicaID = ucionicaID;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public boolean isPC() {
        return isPC;
    }

    public void setPC(boolean PC) {
        isPC = PC;
    }

    public int getMesta() {
        return mesta;
    }

    public void setMesta(int mesta) {
        this.mesta = mesta;
    }

    @Override
    public String toString() {
        return "Ucionica{" +
                "ucionicaID=" + ucionicaID +
                ", broj=" + broj +
                ", isPC=" + isPC +
                ", mesta=" + mesta +
                '}';
    }
}
