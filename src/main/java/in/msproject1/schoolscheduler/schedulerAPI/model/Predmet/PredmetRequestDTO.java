package in.msproject1.schoolscheduler.schedulerAPI.model.Predmet;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PredmetRequestDTO {

    @JsonProperty("naziv")
    private String naziv;

    @JsonProperty("studijskiProgram")
    private String studijskiProgram;

    @JsonProperty("ESPB")
    private int ESPB;

    public PredmetRequestDTO() {
    }

    public PredmetRequestDTO(String naziv, String studijskiProgram, int ESPB) {
        this.naziv = naziv;
        this.studijskiProgram = studijskiProgram;
        this.ESPB = ESPB;
    }
}

