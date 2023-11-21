package in.msproject1.schoolscheduler.schedulerAPI.DAO;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class BinaryIncrementorHelperClass implements IdentifierGenerator {
    private static int sequence = 0;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        int id = (int) Math.pow(2, sequence++);
        return id;
    }
}
