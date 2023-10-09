package com.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@JsonFilter("SomeBeanFilter")
public class SomeBean3 {

    String field1;

    String field2;

    String field3;

    public SomeBean3(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }
}
