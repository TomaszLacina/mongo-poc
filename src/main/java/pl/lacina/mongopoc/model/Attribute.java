package pl.lacina.mongopoc.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class Attribute {

    @Id
    private String id;

    private final String name;
    private final AttributeType type;
    private final String stringValue;
    private final Long numericValue;
    private final Date dateValue;
}
