package in.msproject1.schoolscheduler.schedulerAPI.controller.TesterController;

import in.msproject1.schoolscheduler.schedulerAPI.model.Termin.Termin;
import in.msproject1.schoolscheduler.schedulerAPI.service.Termin.ITerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

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

        CheckValuesOfTermin(tr);

        return terminService.saveTermin(tr);
    }

    @PutMapping("/update")
    public Termin updateTermin(@RequestBody Termin tr) {
        CheckValuesOfTermin(tr);
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

    @DeleteMapping("/deleteCustom")
    public Boolean deleteTerminByRequests(@RequestParam int vreme, @RequestParam String dan, @RequestParam int ucionica) {
        return terminService.deleteTerminByParameters(vreme, ucionica, dan);
    }

    @GetMapping("/getSorted")
    public List<Termin> getTerminsSorted(@RequestParam int firstParam, @RequestParam int secondParam)
    {

        return terminService.GetTerminSorted(firstParam, secondParam);

    }

    private void CheckValuesOfTermin(@RequestBody Termin tr) {
        if(tr.getGrupaID() == null || tr.getPredmetID() == null
                || tr.getNastavnikID() == null || tr.getStartTime() == null || tr.getEndTime() == null
                || tr.getUcionicaID() == null || tr.getDay() == null || tr.getTipNastave() == null)
        {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Invalid values given.");
        }
    }


}
