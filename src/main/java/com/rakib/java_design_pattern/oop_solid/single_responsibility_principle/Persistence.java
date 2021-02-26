package com.rakib.java_design_pattern.oop_solid.single_responsibility_principle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Persistence {

    //Only One Responsibility or task for One Class
    public void saveToFile(Journal journal, String fileName, boolean overWrite) throws FileNotFoundException {
        if (overWrite || new File(fileName).exists()){
            try (PrintStream out = new PrintStream(fileName)){
                out.println(journal);
            }
        }
    }

}
