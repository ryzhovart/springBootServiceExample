package com.rest.webservices.restfulwebservices.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.bridge.IMessage;

@Data
public class HelloWorldBean {

   private String message;
    public HelloWorldBean(String message) {
        this.message = message;
    }
}
