package com.hodor.designpattern.abstractfactory;

public class DatabaseResponse implements Response{
    @Override
    public String getResponse() {
        return "Database response";
    }
}
