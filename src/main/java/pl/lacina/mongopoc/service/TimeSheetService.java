package pl.lacina.mongopoc.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import pl.lacina.mongopoc.model.TimeSheet;

@Component
@RequiredArgsConstructor
public class TimeSheetService {

  private final MongoTemplate mongoTemplate;


  public List<TimeSheet> getKrakowskie() {
    Query query = new Query();

    Criteria first = Criteria.where("attributes")
        .elemMatch(Criteria.where("name").is("Sygnatura kursu").and("stringValue").is("KRA_JEE_W03"));
    Criteria second = Criteria.where("attributes")
        .elemMatch(Criteria.where("name").is("Miejsce wykladow").and("stringValue").is("KRAKOW"));

    query.addCriteria(new Criteria().andOperator(first, second));

    return mongoTemplate.find(query, TimeSheet.class);

  }

  public List<TimeSheet> getOracze() {
    Query query = new Query();

    Criteria first = Criteria.where("attributes")
        .elemMatch(Criteria.where("name").is("Pole").and("stringValue").is("Pod lasem"));
    Criteria second = Criteria.where("attributes")
        .elemMatch(Criteria.where("name").is("Praca").and("stringValue").is("Oranie"));

    query.addCriteria(new Criteria().andOperator(first, second).andOperator());

    return mongoTemplate.find(query, TimeSheet.class);

  }


    public List<TimeSheet> getEloRapy() {
        Query query = new Query();

        Criteria first = Criteria.where("attributes")
            .elemMatch(Criteria.where("name").is("Nowy").and("stringValue").is("Nowiutki"));
        Criteria second = Criteria.where("attributes")
            .elemMatch(Criteria.where("name").is("Elo").and("stringValue").is("Rapy"));

        query.addCriteria(new Criteria().andOperator(first, second));

        return mongoTemplate.find(query, TimeSheet.class);

    }
}
