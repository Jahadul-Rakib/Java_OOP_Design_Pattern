package com.rakib.java_design_pattern.a_oop_solid.interface_segrigation_principle;

import lombok.Data;

import java.util.List;

@Data
class Document {
    private String documentName;
    private String documentType;
}

// On Old Fashion
interface Machine {
    void print(Document document);

    void scan(Document document);

    void fax(Document document);
}

//After Applying Interface Segrigation
interface Printer {
    void print(Document document);

    void printAll(List<Document> document);
}

interface Scanner {
    void scan(Document document);

    void afterScan(Document document);
}

interface FaxMachine {
    void fax(Document document);

    void sendFax(Document document);

    void getFax(Document document);
}
//Now i can implinet which actually i need
public class InterfaceSegrigationExample {
    public static void main(String[] args) {

    }
}
