package com.hodor.designpattern.abstractfactory;

public interface DataSourceAbstractFactory {

    Service createService();
    Response createResponse();
}
