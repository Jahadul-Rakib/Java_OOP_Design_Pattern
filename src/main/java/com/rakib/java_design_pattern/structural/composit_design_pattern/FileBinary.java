package com.rakib.java_design_pattern.structural.composit_design_pattern;

public class FileBinary extends File {

    private long size;

    public FileBinary(String fileName, long size) {
        super(fileName);
        this.size = size;
    }

    @Override
    public void ls() {
        System.out.println(getFileName() + "\t" + size);
    }

    @Override
    public void addFile(File file) {
        throw new UnsupportedOperationException("Do Not Support Add Operation.");
    }

    @Override
    public File[] getFiles() {
        throw new UnsupportedOperationException("Do Not Support Get Operation.");
    }

    @Override
    public boolean removeFile(File file) {
        throw new UnsupportedOperationException("Do Not Support Remove Operation.");
    }
}
