package in.msproject1.schoolscheduler.schedulerAPI.controller;

import in.msproject1.schoolscheduler.schedulerAPI.model.Grupa;
import in.msproject1.schoolscheduler.schedulerAPI.model.Ucionica;
import in.msproject1.schoolscheduler.schedulerAPI.service.Grupa.IGrupaService;
import in.msproject1.schoolscheduler.schedulerAPI.service.Ucionica.IUcionicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ucionica")
public class UcionicaController {

    @Autowired
    private IUcionicaService ucionicaService;

    @GetMapping("/custom")
    public List<Ucionica> GetCustomUcionice(@RequestParam int isPC){
        Boolean parametar;
        if(isPC == 0){
            parametar = false;
        }else
        {
            parametar = true;
        }

        return ucionicaService.GetUcionicaCustom(parametar);
    }

    @GetMapping("/all")
    public List<Ucionica> getUcionice() {
        return ucionicaService.GetUcionicaTables();
    }

    @PostMapping("/add")
    public Ucionica saveUcionica(@RequestBody Ucionica uc) {
        return ucionicaService.saveUcionica(uc);
    }

    @PutMapping("/update")
    public Ucionica updateUcionica(@RequestBody Ucionica uc) {
        return ucionicaService.updateUcionica(uc);
    }

    @GetMapping("/get")
    public Ucionica getUcionica(@RequestParam int id) {
        return ucionicaService.GetUcionica(id);
    }

    @DeleteMapping("/delete")
    public Boolean deleteUcionica(@RequestParam int id) {
        return ucionicaService.deleteUcionica(id);
    }

}
