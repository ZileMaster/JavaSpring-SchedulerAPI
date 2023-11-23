package in.msproject1.schoolscheduler.schedulerAPI.controller.TesterController;

import in.msproject1.schoolscheduler.schedulerAPI.model.Termin.TerminDTO;
import in.msproject1.schoolscheduler.schedulerAPI.service.Termin.ITerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/raspored")
public class RasporedController {

    @Autowired
    private ITerminService terminServ;

    @GetMapping("/getByDay")
    public List<TerminDTO> GetTerminsByDayAndUcionica(@RequestParam String day, @RequestParam int UcionicaID)
    {
        return terminServ.GetTerminsByDayAndUcionica(day, UcionicaID);
    }
    @GetMapping("/getByGroup")
    public List<TerminDTO> GetTerminsByGroup(@RequestParam int groupID)
    {
        return terminServ.GetTerminsByGroup(groupID);
    }
    @GetMapping("/getByNastavnik")
    public List<TerminDTO> GetTerminsByNastavnik(@RequestParam int nastavnikID)
    {
        return terminServ.GetTerminsByNastavnik(nastavnikID);
    }
    @GetMapping("/getByPredmet")
    public List<TerminDTO> GetTerminsByPredmet(@RequestParam int predmetID)
    {
        return terminServ.GetTerminsByPredmetID(predmetID);
    }
}
