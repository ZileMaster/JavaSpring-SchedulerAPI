package in.msproject1.schoolscheduler.schedulerAPI.model.Predmet;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

@Entity
@Table(name = "Predmet")
public class Predmet{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GenericGenerator(name = "binary_increment", strategy = "in.msproject1.schoolscheduler.schedulerAPI.model.Predmet.Predmet")
    @Column
    private int id;

    @Column
    private String naziv;

    @Column
    private String studijskiProgram;

    @Column
    private int ESPB;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getStudijskiProgram() {
        return studijskiProgram;
    }

    public void setStudijskiProgram(String studijskiProgram) {
        this.studijskiProgram = studijskiProgram;
    }

    public int getESPB() {
        return ESPB;
    }

    public void setESPB(int ESPB) {
        this.ESPB = ESPB;
    }

//    @Override
//    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
//        int nextId = (int) Math.pow(2, ++sequence + 1);
//        return nextId;
//    }
//
//    private static int sequence = 0;

    @Override
    public String toString() {
        return "Predmet{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", studijskiProgram='" + studijskiProgram + '\'' +
                ", ESPB=" + ESPB +
                '}';
    }
}