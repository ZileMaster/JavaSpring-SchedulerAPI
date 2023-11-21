package in.msproject1.schoolscheduler.schedulerAPI.controller.TesterController;

import in.msproject1.schoolscheduler.schedulerAPI.model.Tester;
import in.msproject1.schoolscheduler.schedulerAPI.service.Tester.ITesterService;
import in.msproject1.schoolscheduler.schedulerAPI.service.Tester.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TesterController {

    @Autowired
    private ITesterService testServ;

    @GetMapping("/testerEndpoint")
    public List<Tester> getTesters(){
        return testServ.GetTesterTables();
    }

    @PostMapping("/testerAdd")
    public Tester saveTester(@RequestBody Tester testBody){
        return testServ.save(testBody);
    }

    @PutMapping("/testerUpdate")
    public Tester updateTester(@RequestBody Tester testBody){
        return  testServ.updateTester(testBody);
    }

    @GetMapping("/tester")
    public Tester getTester(@RequestParam int id){
        return testServ.GetSingle(id);
    }

    @DeleteMapping("/tester")
    public Boolean deleteTester(@RequestParam int id){
        return testServ.delete(id);
    }

}
