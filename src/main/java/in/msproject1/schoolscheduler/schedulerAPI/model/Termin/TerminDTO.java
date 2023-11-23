package in.msproject1.schoolscheduler.schedulerAPI.model.Termin;

import in.msproject1.schoolscheduler.schedulerAPI.model.Grupa;
import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik.Nastavnik;
import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet.Predmet;
import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet.PredmetRequestDTO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Ucionica;

public class TerminDTO {

    private String day;
    private String hours;
    private Nastavnik nastavnik;
    private PredmetRequestDTO predmet;
    private Grupa grupa;
    private Ucionica ucionica;
}
