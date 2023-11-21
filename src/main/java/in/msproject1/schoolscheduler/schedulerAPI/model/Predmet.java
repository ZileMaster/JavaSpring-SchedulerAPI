package in.msproject1.schoolscheduler.schedulerAPI.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

@Entity
@Table(name = "Predmet")
public class Predmet implements IdentifierGenerator {

    @Id
    @GeneratedValue(generator = "binary_increment")
    @GenericGenerator(name = "binary_increment", strategy = "in.msproject1.schoolscheduler.schedulerAPI.model.Predmet")
    @Column
    private int id;

    @Column
    private String naziv;

    @Column
    private String studijskiProgram;

    @Column
    private int ESPB;

    // Constructors, getters, setters, and other methods...

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        int nextId = (int) Math.pow(2, sequence++);
        return nextId;
    }

    private static int sequence = 0;

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