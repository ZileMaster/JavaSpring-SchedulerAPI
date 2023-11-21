package in.msproject1.schoolscheduler.schedulerAPI.controller.TesterController;

import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet;
import in.msproject1.schoolscheduler.schedulerAPI.model.Termin;
import in.msproject1.schoolscheduler.schedulerAPI.service.Predmet.IPredmetService;
import in.msproject1.schoolscheduler.schedulerAPI.service.Termin.ITerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/termin")
public class TerminController {

    @Autowired
    private ITerminService terminService;

    @GetMapping("/all")
    public List<Termin> getTermine() {
        return terminService.GetTerminTables();
    }

    @PostMapping("/add")
    public Termin saveTermin(@RequestBody Termin tr) {
        return terminService.saveTermin(tr);
    }

    @PutMapping("/update")
    public Termin updateTermin(@RequestBody Termin tr) {
        return terminService.updateTermin(tr);
    }

    @GetMapping("/get")
    public Termin getTermin(@RequestParam int id) {
        return terminService.GetTermin(id);
    }

    @DeleteMapping("/delete")
    public Boolean deleteTermin(@RequestParam int id) {
        return terminService.deleteTermin(id);
    }

}
