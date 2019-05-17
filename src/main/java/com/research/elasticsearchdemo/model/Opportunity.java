package com.research.elasticsearchdemo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.Date;

import static org.springframework.data.elasticsearch.annotations.FieldType.Nested;

@Document(indexName = "opportunity")
@Data
@Builder
public class Opportunity {
    @Id
    private int id;

    private String name;

    private String researchField;

    private Date closingDate;

    private long amount;

    private String ccy;

    @Field(type = Nested, includeInParent = true)
    private Contact contact;
}
