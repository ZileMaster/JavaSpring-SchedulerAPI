package in.msproject1.schoolscheduler.schedulerAPI.service.Tester;

import in.msproject1.schoolscheduler.schedulerAPI.DAO.Tester.ITesterDAO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Tester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TesterService implements ITesterService{

    @Autowired
    private ITesterDAO testerDAO;

    @Transactional
    @Override
    public List<Tester> GetTesterTables() {
        try {
            return testerDAO.GetTesterTables();
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Tester GetSingle(int id) {
        try {
            return testerDAO.GetSingle(id);
        }catch (Exception e){
            throw e;
        }
    }

    @Transactional
    @Override
    public Tester save(Tester test) {
        try {
            return testerDAO.save(test);
        } catch (Exception e) {
            // Log or handle the exception, then rethrow it
            throw e;
        }
    }

    @Transactional
    @Override
    public Boolean delete(int id) {
        try{
            return testerDAO.delete(id);
        }catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Tester updateTester(Tester test) {
        try{
            return testerDAO.save(test);
        }catch (Exception e) {
            throw e;
        }
    }
}
