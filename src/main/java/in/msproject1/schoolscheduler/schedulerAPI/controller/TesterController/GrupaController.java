package in.msproject1.schoolscheduler.schedulerAPI.controller.TesterController;

import in.msproject1.schoolscheduler.schedulerAPI.model.Grupa;
import in.msproject1.schoolscheduler.schedulerAPI.service.Grupa.IGrupaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupa")
public class GrupaController {

    @Autowired
    private IGrupaService grupaService;

    @GetMapping("/all")
    public List<Grupa> getGrupe() {
        return grupaService.GetGrupaTables();
    }

    @PostMapping("/add")
    public Grupa saveGrupa(@RequestBody Grupa gr) {
        return grupaService.saveGrupa(gr);
    }

    @PutMapping("/update")
    public Grupa updateGrupa(@RequestBody Grupa nastavnik) {
        return grupaService.updateGrupa(nastavnik);
    }

    @GetMapping("/get")
    public Grupa getGrupa(@RequestParam int id) {
        return grupaService.GetGrupa(id);
    }

    @DeleteMapping("/delete")
    public Boolean deleteGrupa(@RequestParam int id) {
        return grupaService.deleteGrupa(id);
    }
}
