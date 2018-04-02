package ru.tsystems.javaschool.goldenguide.controller.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tsystems.javaschool.goldenguide.controller.GreetingController;

@RestController
@RequestMapping("/greeting")
public class GreetingControllerImpl implements GreetingController {

    @Override
    @GetMapping("/hello")
    public String greeting() {
        return "Hello, World!";
    }

    @Override
    @GetMapping("/hello/{name}")
    public String greeting(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @Override
    @GetMapping("/whatisanswer")
    public String findAnswer(@RequestParam(required = false, defaultValue = "42") String answer) {
        return "Answer is " + answer;
    }
}
