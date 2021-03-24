package pl.lacina.mongopoc.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@RequiredArgsConstructor
@Getter
public class TimeSheet {

    @Id
    private String id;

    private final String userName;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final List<Attribute> attributes;




}
