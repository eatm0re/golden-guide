package ru.tsystems.javaschool.goldenguide.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/hello")
    public String greeting() {
        return "Hello, World!";
    }

    @GetMapping("/hello/{name}")
    public String greeting(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/whatisanswer")
    public String findAnswer(@RequestParam(required = false, defaultValue = "42") String answer) {
        return "Answer is " + answer;
    }
}
