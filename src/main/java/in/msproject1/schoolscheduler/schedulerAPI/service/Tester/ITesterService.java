package in.msproject1.schoolscheduler.schedulerAPI.service.Tester;

import in.msproject1.schoolscheduler.schedulerAPI.model.Tester;

import java.util.List;

public interface ITesterService {

    List<Tester> GetTesterTables();

    Tester GetSingle(int id);

    Tester save(Tester test);

    Boolean delete(int id);

    Tester updateTester(Tester test);
}
