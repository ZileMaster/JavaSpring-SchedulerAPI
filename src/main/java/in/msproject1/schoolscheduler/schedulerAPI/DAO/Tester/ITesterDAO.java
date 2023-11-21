package in.msproject1.schoolscheduler.schedulerAPI.DAO.Tester;

import in.msproject1.schoolscheduler.schedulerAPI.model.Tester;

import java.util.List;

public interface ITesterDAO {
    List<Tester> GetTesterTables();

    Tester GetSingle(int id);

    Tester save(Tester test);

    Boolean delete(int id);

    //Tester updateTest(Tester test);
}
