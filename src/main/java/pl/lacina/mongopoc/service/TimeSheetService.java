package pl.lacina.mongopoc.service;

import com.mongodb.MongoException;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.DocumentCallbackHandler;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import pl.lacina.mongopoc.model.TimeSheet;

import java.util.List;

@RequiredArgsConstructor
public class TimeSheetService {

    private final MongoTemplate mongoTemplate;


    public List<TimeSheet> getKrakowskie() {
        Query query = new Query();

        Criteria first = Criteria.where("attribute").elemMatch(Criteria.where("name").is("Sygnatura kursu").and("stringValue").is("KRA_JEE_W03"));
        Criteria second = Criteria.where("attribute").elemMatch(Criteria.where("name").is("Miejsce wykladow").and("stringValue").is("KRAKOW"));

        query.addCriteria(new Criteria().andOperator(first, second));


        return mongoTemplate.find(query, TimeSheet.class);

    }

    public List<TimeSheet> getOracze() {
        Query query = new Query();

        Criteria first = Criteria.where("attribute").elemMatch(Criteria.where("name").is("Pole").and("stringValue").is("Pod lasem"));
        Criteria second = Criteria.where("attribute").elemMatch(Criteria.where("name").is("Praca").and("stringValue").is("Oranie"));

        query.addCriteria(new Criteria().andOperator(first, second));


        return mongoTemplate.find(query, TimeSheet.class);

    }
}
