package com.hodor.designpattern.behavioral.visitor;

public interface ReportElement {

    <R> R accept(ReportVisitor<R> visitor);
}
