package com.example.studentdata;

public class students {
    String name;
    String pass;
    String cource;

    public students(String name, String pass, String cource) {
        this.name = name;
        this.pass = pass;
        this.cource = cource;
    }

    public String getUser() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getcource() {
        return cource;
    }
}
