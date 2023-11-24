package in.msproject1.schoolscheduler.schedulerAPI.controller;

import com.sun.net.httpserver.HttpContext;
import in.msproject1.schoolscheduler.schedulerAPI.model.Termin.TerminDTO;
import in.msproject1.schoolscheduler.schedulerAPI.service.Termin.ITerminService;
import in.msproject1.schoolscheduler.schedulerAPI.service.Termin.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/enterByCSV")
    public Boolean enterEntriesByCSV(@RequestParam("file") MultipartFile file)
    {
        if(file.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Invalid values given.");
        }
        try {

            System.out.println("Uploaded CSV content:");
            System.out.println(new String(file.getBytes()));

            terminServ.InsertStuffByCSV(file);

            return true;
        } catch (Exception e) {
            // Handle exceptions, such as invalid CSV format, processing errors, etc.
            e.printStackTrace();
            return false;
        }
    }
}
