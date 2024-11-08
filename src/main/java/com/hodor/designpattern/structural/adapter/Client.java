package com.hodor.designpattern.structural.adapter;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        DatabaseDataGenerateur gen = new DatabaseDataGenerateur();
        DisplayDataAdapter adapter = new DisplayDataAdapter();

        List<DisplayData3rdParty> legacyData = adapter.convertData(gen.generateDate());

        for(DisplayData3rdParty datum : legacyData) {
            datum.displayData();
        }

    }
}
