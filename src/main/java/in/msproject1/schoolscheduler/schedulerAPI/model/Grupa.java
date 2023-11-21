package in.msproject1.schoolscheduler.schedulerAPI.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Grupa")
public class Grupa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int groupID;

    @Column
    private int grupa;

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getGrupa() {
        return grupa;
    }

    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return "Grupa{" +
                "groupID=" + groupID +
                ", grupa=" + grupa +
                '}';
    }
}
