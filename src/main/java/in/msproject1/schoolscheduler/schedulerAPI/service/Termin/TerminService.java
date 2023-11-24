package in.msproject1.schoolscheduler.schedulerAPI.service.Termin;

import in.msproject1.schoolscheduler.schedulerAPI.DAO.Grupa.IGrupaDAO;
import in.msproject1.schoolscheduler.schedulerAPI.DAO.Nastavnik.INastavnikDAO;
import in.msproject1.schoolscheduler.schedulerAPI.DAO.Predmet.IPredmetDAO;
import in.msproject1.schoolscheduler.schedulerAPI.DAO.Termin.ITerminDAO;
import in.msproject1.schoolscheduler.schedulerAPI.DAO.Ucionica.IUcionicaDAO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Grupa;
import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik.Nastavnik;
import in.msproject1.schoolscheduler.schedulerAPI.model.Nastavnik.NastavnikDTO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Predmet.Predmet;
import in.msproject1.schoolscheduler.schedulerAPI.model.Termin.Termin;
import in.msproject1.schoolscheduler.schedulerAPI.model.Termin.TerminDTO;
import in.msproject1.schoolscheduler.schedulerAPI.model.Ucionica;
import in.msproject1.schoolscheduler.schedulerAPI.service.Nastavnik.INastavnikService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class TerminService implements ITerminService{

    @Autowired
    ITerminDAO terminDAO;

    @Autowired
    IPredmetDAO predmetDAO;

    @Autowired
    INastavnikDAO nastavnikDAO;

    @Autowired
    IGrupaDAO grupaDAO;

    @Autowired
    IUcionicaDAO ucionicaDAO;

    @Transactional
    @Override
    public void InsertStuffByCSV(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {

                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] columns = line.split(",");

                Predmet pred = new Predmet();
                pred = predmetDAO.getPredmetByName(removeQuotes(columns[0]));

                if(pred == null)
                {
                    pred = new Predmet();
                    pred.setESPB(6);
                    pred.setNaziv(removeQuotes(columns[0]));
                    pred.setStudijskiProgram("RI");
                    pred = predmetDAO.savePredmet(pred);
                }

                String tipPredavanja = removeQuotes(columns[1]); //(for lejtr)

                Nastavnik nastForLater = new Nastavnik();

                NastavnikDTO nast = new NastavnikDTO();
                nast = nastavnikDAO.GetNastavnikCustom(removeQuotes(columns[2].split(" ")[1]), removeQuotes(columns[2].split(" ")[0]));
                if(nast == null || nast.getId() == 0){
                    Nastavnik nastavnik = new Nastavnik();
                    nastavnik.setPredmeti(String.valueOf(pred.getId()));
                    nastavnik.setIme( removeQuotes(columns[2].split(" ")[1] ));
                    nastavnik.setPrezime( removeQuotes(columns[2].split(" ")[0]));
                    nastavnik.setZvanje("dr");//default

                    nastForLater = nastavnikDAO.saveNastavnik(nastavnik);
                }else {
                    //handling existing prof
                    Nastavnik nastavnik = new Nastavnik();
                    nastavnik.setIme(nast.getIme());
                    nastavnik.setPrezime(nast.getPrezime());
                    nastavnik.setZvanje("dr");//default
                    nastavnik.setNastavnikID(nast.getId());

                    List<Integer> oldPred = new ArrayList<Integer>();


                    for (Predmet p : nast.getPredmet()
                    ) {

                        oldPred.add(p.getId());

                    }
                    StringBuilder uniqueIdsBuilder = new StringBuilder();
                    for (Integer id : oldPred) {
                        uniqueIdsBuilder.append(id).append(",");
                    }

                    // Remove the trailing comma if it's the last symbol
                    String uniqueIdsString = uniqueIdsBuilder.toString().replaceAll(",$", "");

                    nastavnik.setPredmeti(uniqueIdsString);

                    nastForLater = nastavnikDAO.saveNastavnik(nastavnik);
                }

                int i = 4;
                Grupa gr = new Grupa();
                int grNum;

                if(columns[3].contains(","))
                {
                    grNum = Integer.parseInt(removeQuotes(columns[3].split(",")[0]));
                }
                else
                {
                    grNum = Integer.parseInt(removeQuotes(columns[3]));
                }

                for(i = 4; i < 15; i++){
                    if(checkValues(columns[i])){
                        break;
                    }
                }

                gr = grupaDAO.getGrupaByNum(grNum);
                if(gr == null){
                    gr = new Grupa();
                    gr.setGrupa(Integer.parseInt(removeQuotes(columns[3])));
                    gr = grupaDAO.saveGrupa(gr);
                }

                String day = removeQuotes(columns[i]);
                String dayOfWeek;

                if (day.contains("PON")) {
                    dayOfWeek = "Monday";
                } else if (day.contains("UTO")) {
                    dayOfWeek = "Tusday";
                } else if (day.contains("SRE")) {
                    dayOfWeek = "Wednesday";
                } else if (day.contains("ČET")) {
                    dayOfWeek = "Thursday";
                } else if (day.contains("PET")) {
                    dayOfWeek = "Friday";
                } else if (day.contains("SUB")) {
                    dayOfWeek = "Saturday";
                } else if (day.contains("NED")) {
                    dayOfWeek = "Sunday";
                } else {
                    dayOfWeek = "Unknown";
                }

                    int terminStart = Integer.parseInt(removeQuotes(columns[++i].split("-")[0].split(":")[0]));
                    int terminEnd = Integer.parseInt(removeQuotes(columns[i].split("-")[1]));

                    int numClassRoom = extractNumber(removeQuotes(columns[++i]));

                    Ucionica uc = new Ucionica();
                    uc = ucionicaDAO.GetUcionicaByNumber(numClassRoom);

                    if(uc == null)
                    {
                        uc = new Ucionica();
                        uc.setBroj(numClassRoom);
                        uc.setMesta(15);
                        uc.setPC(false);
                        uc = ucionicaDAO.saveUcionica(uc);
                    }

                    Termin term = new Termin();
                    term.setDay(dayOfWeek);
                    term.setNastavnikID(nastForLater.getNastavnikID());
                    term.setEndTime(terminEnd);
                    term.setStartTime(terminStart);
                    term.setGrupaID(gr.getGroupID());
                    term.setPredmetID(pred.getId());

                    String tip = "";
                    if(tipPredavanja.contains("V")){
                        tip = "Vezbe";
                    } else if (tipPredavanja.contains("P")) {
                        tip = "Predavanje";
                    } else if(tipPredavanja.contains("D")){
                        tip = "Demonstracije";
                    }

                    term.setTipNastave(tip);
                    term.setUcionicaID(uc.getUcionicaID());
                    terminDAO.saveTermin(term);

                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    @Override
    public List<Termin> GetTerminTables() {
        try {
            return terminDAO.GetTerminAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Termin GetTermin(int id) {
        try {
            return terminDAO.GetTerminSingle(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Termin saveTermin(Termin tr) {
        try {
            return terminDAO.saveTermin(tr);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Boolean deleteTermin(int id) {
        try {
            return terminDAO.deleteTermin(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Termin updateTermin(Termin tr) {
        try {
            return terminDAO.saveTermin(tr);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Boolean deleteTerminByParameters(int vreme, int ucionica, String dan) {
        if (vreme < 0 || ucionica < 1 || dan.length() < 3)
        {
            return false;
        }

        try {
            return terminDAO.deleteTerminByParameters(vreme, ucionica, dan);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public List<Termin> GetTerminSorted(int firstParam, int secondParam) {
        try {
            return terminDAO.GetTerminsSorted(firstParam, secondParam);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public List<TerminDTO> GetTerminsByDayAndUcionica(String day, int ucionicaID) {
        try {
            return terminDAO.GetTerminsByDayAndUcionica(day, ucionicaID);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public List<TerminDTO> GetTerminsByGroup(int groupID) {
        try {
            return terminDAO.GetTerminsByGroup(groupID);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public List<TerminDTO> GetTerminsByNastavnik(int nastavnikID) {
        try {
            return terminDAO.GetTerminsByNastavnik(nastavnikID);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public List<TerminDTO> GetTerminsByPredmetID(int predmetID) {
        try {
            return terminDAO.GetTerminsByPredmet(predmetID);
        } catch (Exception e) {
            throw e;
        }
    }

    private static int extractNumber(String input) {
        Pattern pattern = Pattern.compile("\\b?\\d+\\b?");

        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }

        return -1;
    }

    private String removeQuotes(String input) {
        return input.replaceAll("\"", "");
    }

    private Boolean checkValues(String str){
        if (str.contains("PON")) {
            return true;
        } else if (str.contains("UTO")) {
            return true;
        } else if (str.contains("SRE")) {
            return true;
        } else if (str.contains("ČET")) {
            return true;
        } else if (str.contains("PET")) {
            return true;
        } else if (str.contains("SUB")) {
            return true;
        } else if (str.contains("NED")) {
            return true;
        } else {
            return false;
        }
    }
}
