package pl.lacina.mongopoc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.lacina.mongopoc.model.TimeSheet;

public interface TimeSheetRepository extends MongoRepository<TimeSheet, String> {
}
