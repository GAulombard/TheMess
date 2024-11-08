package com.hodor.designpattern.creational.abstractfactory;

public interface DataSourceAbstractFactory {

    Service createService();
    Response createResponse();
}
