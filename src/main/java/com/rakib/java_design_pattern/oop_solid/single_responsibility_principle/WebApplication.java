package com.rakib.java_design_pattern.oop_solid.single_responsibility_principle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@Slf4j
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(WebApplication.class, args);

        Journal journal = new Journal();
        journal.addEntries("I want Talk is 1");
        journal.addEntries("I want Talk is 2");
        journal.addEntries("I want Talk is 3");
        journal.addEntries("I want Talk is 4");
        journal.addEntries("I want Talk is 5");
        journal.addEntries("I want Talk is 6");
        log.info(String.valueOf(journal));

        //Only One Responsibility or task for One Class
        Persistence persistence = new Persistence();
        String fileName = "C:\\temp\\journal.txt";
        persistence.saveToFile(journal, fileName, true);

        Runtime.getRuntime().exec("notepad.exe "+fileName);
    }

}
