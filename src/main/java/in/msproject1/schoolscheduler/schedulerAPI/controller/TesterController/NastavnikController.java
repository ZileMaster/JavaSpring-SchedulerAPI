package in.msproject1.schoolscheduler.schedulerAPI.controller.TesterController;


import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik.Nastavnik;
import in.msproject1.schoolscheduler.schedulerAPI.service.Nastavnik.INastavnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nastavnik")
public class NastavnikController {

    @Autowired
    private INastavnikService nastavnikService;

    @GetMapping("/all")
    public List<Nastavnik> getNastavnike() {
        return nastavnikService.GetNastavnikTables();
    }

    @PostMapping("/add")
    public Nastavnik saveNastavnik(@RequestBody Nastavnik nastavnik) {
        return nastavnikService.saveNastavnik(nastavnik);
    }

    @GetMapping("/custom")
    public Object getNastavnikCustom(@RequestParam String ime, @RequestParam String prezime)
    {
        return nastavnikService.GetNastavnikCustom(ime, prezime);
    }

    @PutMapping("/update")
    public Nastavnik updateNastavnik(@RequestBody Nastavnik nastavnik) {
        return nastavnikService.updateNastavnik(nastavnik);
    }

    @GetMapping("/get")
    public Nastavnik getNastavnik(@RequestParam int id) {
        return nastavnikService.GetNastavnik(id);
    }

    @DeleteMapping("/delete")
    public Boolean deleteNastavnik(@RequestParam int id) {
        return nastavnikService.deleteNastavnik(id);
    }
}
