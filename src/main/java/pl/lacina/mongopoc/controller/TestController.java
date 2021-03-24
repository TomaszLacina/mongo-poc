package pl.lacina.mongopoc.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lacina.mongopoc.model.Attribute;
import pl.lacina.mongopoc.model.AttributeType;
import pl.lacina.mongopoc.model.TimeSheet;
import pl.lacina.mongopoc.repository.TimeSheetRepository;
import pl.lacina.mongopoc.service.TimeSheetService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TimeSheetRepository timeSheetRepository;
    private final TimeSheetService timeSheetService;

    @GetMapping("/createTestData")
    public List<TimeSheet> createTestData() {
        List<TimeSheet> timeSheetList = new ArrayList<>();
        List<Attribute> firstListOfAttributes = new ArrayList<>();

        firstListOfAttributes.add(new Attribute("Sygnatura kursu", AttributeType.STRING, "KRA_JEE_W03", null, null));
        firstListOfAttributes.add(new Attribute("Miejsce wykladow", AttributeType.STRING, "KRAKOW", null, null));
        firstListOfAttributes.add(new Attribute("Stawka", AttributeType.NUMERIC, null, 99999L, null));

        List<Attribute> secondListOfAttributes = new ArrayList<>();
        firstListOfAttributes.add(new Attribute("Pole", AttributeType.STRING, "Pod lasem", null, null));
        firstListOfAttributes.add(new Attribute("Praca", AttributeType.STRING, "Oranie", null, null));
        firstListOfAttributes.add(new Attribute("Ile to Hektorow?", AttributeType.NUMERIC, null, 3L, null));


        timeSheetRepository.save(new TimeSheet("Tomasz", LocalDateTime.now().minusDays(5), LocalDateTime.now().minusDays(5).plusHours(8), firstListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Tomasz", LocalDateTime.now().minusDays(4), LocalDateTime.now().minusDays(4).plusHours(8), firstListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Tomasz", LocalDateTime.now().minusDays(3), LocalDateTime.now().minusDays(3).plusHours(8), firstListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Tomasz", LocalDateTime.now().minusDays(2), LocalDateTime.now().minusDays(2).plusHours(8), firstListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Tomasz", LocalDateTime.now().minusDays(1), LocalDateTime.now().minusDays(1).plusHours(8), firstListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Tomasz", LocalDateTime.now().minusDays(5), LocalDateTime.now().minusDays(5).plusHours(8), secondListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Tomasz", LocalDateTime.now().minusDays(4), LocalDateTime.now().minusDays(4).plusHours(8), secondListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Tomasz", LocalDateTime.now().minusDays(3), LocalDateTime.now().minusDays(3).plusHours(8), secondListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Tomasz", LocalDateTime.now().minusDays(2), LocalDateTime.now().minusDays(2).plusHours(8), secondListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Tomasz", LocalDateTime.now().minusDays(1), LocalDateTime.now().minusDays(1).plusHours(8), secondListOfAttributes));


        timeSheetRepository.save(new TimeSheet("Janusz Korwin-Mikke", LocalDateTime.now().minusDays(5), LocalDateTime.now().minusDays(5).plusHours(8), firstListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Janusz Korwin-Mikke", LocalDateTime.now().minusDays(4), LocalDateTime.now().minusDays(4).plusHours(8), firstListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Janusz Korwin-Mikke", LocalDateTime.now().minusDays(3), LocalDateTime.now().minusDays(3).plusHours(8), firstListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Janusz Korwin-Mikke", LocalDateTime.now().minusDays(2), LocalDateTime.now().minusDays(2).plusHours(8), firstListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Janusz Korwin-Mikke", LocalDateTime.now().minusDays(1), LocalDateTime.now().minusDays(1).plusHours(8), firstListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Janusz Korwin-Mikke", LocalDateTime.now().minusDays(5), LocalDateTime.now().minusDays(5).plusHours(8), secondListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Janusz Korwin-Mikke", LocalDateTime.now().minusDays(4), LocalDateTime.now().minusDays(4).plusHours(8), secondListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Janusz Korwin-Mikke", LocalDateTime.now().minusDays(3), LocalDateTime.now().minusDays(3).plusHours(8), secondListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Janusz Korwin-Mikke", LocalDateTime.now().minusDays(2), LocalDateTime.now().minusDays(2).plusHours(8), secondListOfAttributes));
        timeSheetRepository.save(new TimeSheet("Janusz Korwin-Mikke", LocalDateTime.now().minusDays(1), LocalDateTime.now().minusDays(1).plusHours(8), secondListOfAttributes));


        return timeSheetList;
    }


    @GetMapping("/getOracze")
    public List<TimeSheet> oracze(){
        return timeSheetService.getOracze();
    }

    @GetMapping("/getKrakowskie")
    public List<TimeSheet> getKrakowskie(){
        return timeSheetService.getKrakowskie();
    }

}
