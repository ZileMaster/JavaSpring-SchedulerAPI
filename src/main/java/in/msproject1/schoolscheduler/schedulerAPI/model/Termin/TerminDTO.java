package in.msproject1.schoolscheduler.schedulerAPI.model.Termin;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import in.msproject1.schoolscheduler.schedulerAPI.model.Grupa;
import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik.Nastavnik;
import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet.Predmet;
import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet.PredmetRequestDTO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Ucionica;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TerminDTO {

    @JsonProperty("day")
    private String day;

    @JsonProperty("hours")
    private String hours;

    @JsonProperty("nastavnik")
    private String nastavnik;

    @JsonProperty("predmet")
    private PredmetRequestDTO predmet;

    @JsonProperty("brojGrupe")
    private Integer brojGrupe;

    @JsonProperty("brojUcionice")
    private Integer brojUcionice;

    public TerminDTO() {
    }

    public TerminDTO(String day, String hours, String nastavnik, PredmetRequestDTO predmet, Integer grupa, Integer ucionica) {
        this.day = day;
        this.hours = hours;
        this.nastavnik = nastavnik;
        this.predmet = predmet;
        this.brojGrupe = grupa;
        this.brojUcionice = ucionica;
    }

}
