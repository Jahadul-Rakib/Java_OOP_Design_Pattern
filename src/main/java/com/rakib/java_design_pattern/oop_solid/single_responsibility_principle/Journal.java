package com.rakib.java_design_pattern.oop_solid.single_responsibility_principle;

import java.util.ArrayList;
import java.util.List;

//Only One Responsibility or task for One Class
public class Journal {

    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntries(String text) {
        entries.add("" + (++count) + ": " + text);
    }

    public void removeEntries(int index) {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }
}
