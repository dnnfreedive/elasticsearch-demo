package com.research.elasticsearchdemo.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Criteria {

    private String researchField;

    private Date closingDate;
}
