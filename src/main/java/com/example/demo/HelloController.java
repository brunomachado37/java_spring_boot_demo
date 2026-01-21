package com.example.demo;

import java.time.Year;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public Message hello(@RequestParam String name, @RequestParam int age) {
        return new Message("Hello " + name + ", you are " + age + " years old.");
    }

    @GetMapping("/birthyear")
    public PersonInfo birthYear(@RequestParam String name,
                                @RequestParam int age) {
        int currentYear = Year.now().getValue();
        int birthYear = currentYear - age;

        return new PersonInfo(name, age, birthYear);
    }
}

class Message {
    public String text;

    public Message(String text) {
        this.text = text;
    }
}

class PersonInfo {
    public String name;
    public int age;
    public int birthYear;

    public PersonInfo(String name, int age, int birthYear) {
        this.name = name;
        this.age = age;
        this.birthYear = birthYear;
    }
}