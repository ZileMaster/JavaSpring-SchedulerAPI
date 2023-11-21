package in.msproject1.schoolscheduler.schedulerAPI.model;

import jakarta.persistence.*;

@Entity
@Table(name = "_tester")
public class Tester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String country;
    @Column(name = "personalDescription")
    private String personalDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPersonalDescription() {
        return personalDescription;
    }

    public void setPersonalDescription(String personalDescription) {
        this.personalDescription = personalDescription;
    }

    @Override
    public String toString() {
        return "Tester{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", personalDescription='" + personalDescription + '\'' +
                '}';
    }
}
