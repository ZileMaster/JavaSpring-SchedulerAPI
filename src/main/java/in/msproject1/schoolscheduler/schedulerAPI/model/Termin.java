package in.msproject1.schoolscheduler.schedulerAPI.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Termin")
public class Termin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer terminID;

    @Column
    private Integer nastavnikID;

    @Column
    private Integer ucionicaID;

    @Column
    private Integer groupID;

    @Column
    private Integer predmetID;

    @Column
    private String tipNastave;

    @Column
    private Integer startTime;

    @Column
    private Integer endTime;

    @Column
    private String day;

    public Integer getPredmetID() {
        return predmetID;
    }

    public void setPredmetID(Integer predmetID) {
        this.predmetID = predmetID;
    }

    public String getTipNastave() {
        return tipNastave;
    }

    public void setTipNastave(String tipNastave) {
        this.tipNastave = tipNastave;
    }

    public Integer getTerminID() {
        return terminID;
    }

    public void setTerminID(Integer terminID) {
        this.terminID = terminID;
    }

    public Integer getNastavnikID() {
        return nastavnikID;
    }

    public void setNastavnikID(Integer nastavnikID) {
        this.nastavnikID = nastavnikID;
    }

    public Integer getUcionicaID() {
        return ucionicaID;
    }

    public void setUcionicaID(Integer ucionicaID) {
        this.ucionicaID = ucionicaID;
    }

    public Integer getGrupaID() {
        return groupID;
    }

    public void setGrupaID(Integer groupID) {
        this.groupID = groupID;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
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
