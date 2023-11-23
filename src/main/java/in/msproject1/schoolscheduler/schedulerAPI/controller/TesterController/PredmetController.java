package in.msproject1.schoolscheduler.schedulerAPI.controller.TesterController;

import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet.Predmet;
import in.msproject1.schoolscheduler.schedulerAPI.service.Predmet.IPredmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/predmet")
public class PredmetController {


    @Autowired
    private IPredmetService predmetService;

    @GetMapping("/all")
    public List<Predmet> getPredmets() {
        return predmetService.GetPredmetTables();
    }

    @PostMapping("/add")
    public Predmet savePredmet(@RequestBody Predmet pr) {

        return predmetService.savePredmet(pr);
    }

    @GetMapping("/byName")
    public Predmet getPredmetByName(@RequestBody String naziv){
        return predmetService.getPredmetByName(naziv);
    }

    @PutMapping("/update")
    public Predmet updatePredmet(@RequestBody Predmet pr) {
        return predmetService.updatePredmet(pr);
    }

    @GetMapping("/get")
    public Predmet getPredmet(@RequestParam int id) {
        return predmetService.GetPredmet(id);
    }

    @DeleteMapping("/delete")
    public Boolean deletePredmet(@RequestParam int id) {
        return predmetService.deletePredmet(id);
    }


}
