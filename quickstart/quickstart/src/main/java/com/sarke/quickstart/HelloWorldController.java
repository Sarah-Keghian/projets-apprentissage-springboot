package com.sarke.quickstart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {

    @GetMapping(path = "/hello") //ANNOTATION TO TELL THAT THIS IS AN ENDPOINT
    public String helloWorld() { return "Hello Sarah!"; }
}
