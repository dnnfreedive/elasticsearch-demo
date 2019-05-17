package com.research.elasticsearchdemo.model;

import lombok.Value;

@Value
public class Contact {

    private final String firstLine;

    private final String address;

    private final String email;

}
