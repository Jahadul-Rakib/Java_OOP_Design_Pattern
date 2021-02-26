package com.rakib.java_design_pattern.b_structural.composit_design_pattern;

import java.util.ArrayList;
import java.util.List;


//Composit on the composit pattern
public class FileDirectory extends File {

    List<File> files = new ArrayList<>();

    public FileDirectory(String fileName) {
        super(fileName);
    }

    @Override
    public void ls() {
        files.forEach(System.out::println);
    }

    @Override
    public void addFile(File file) {
        files.add(file);
    }

    @Override
    public File[] getFiles() {
        return files.toArray(new File[files.size()]);
    }

    @Override
    public boolean removeFile(File file) {
        return files.remove(file);
    }
}
