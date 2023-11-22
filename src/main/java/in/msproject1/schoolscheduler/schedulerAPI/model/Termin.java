package in.msproject1.schoolscheduler.schedulerAPI.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Termin")
public class Termin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int terminID;

    @Column
    private int nastavnikID;

    @Column
    private int ucionicaID;

    @Column
    private int groupID;

    @Column
    private int predmetID;

    @Column
    private String tipNastave;

    @Column
    private int startTime;

    @Column
    private int endTime;

    @Column
    private String day;

    public int getPredmetID() {
        return predmetID;
    }

    public void setPredmetID(int predmetID) {
        this.predmetID = predmetID;
    }

    public String getTipNastave() {
        return tipNastave;
    }

    public void setTipNastave(String tipNastave) {
        this.tipNastave = tipNastave;
    }

    public int getTerminID() {
        return terminID;
    }

    public void setTerminID(int terminID) {
        this.terminID = terminID;
    }

    public int getNastavnikID() {
        return nastavnikID;
    }

    public void setNastavnikID(int nastavnikID) {
        this.nastavnikID = nastavnikID;
    }

    public int getUcionicaID() {
        return ucionicaID;
    }

    public void setUcionicaID(int ucionicaID) {
        this.ucionicaID = ucionicaID;
    }

    public int getGrupaID() {
        return groupID;
    }

    public void setGrupaID(int groupID) {
        this.groupID = groupID;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Termin{" +
                "terminID=" + terminID +
                ", nastavnikID=" + nastavnikID +
                ", ucionicaID=" + ucionicaID +
                ", groupID=" + groupID +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", day='" + day + '\'' +
                '}';
    }
}
