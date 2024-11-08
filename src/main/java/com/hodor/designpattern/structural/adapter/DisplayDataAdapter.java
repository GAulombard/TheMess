package com.hodor.designpattern.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class DisplayDataAdapter implements DatabaseDataConverter {
    @Override
    public List<DisplayData3rdParty> convertData(List<DatabaseData> data) {
        List<DisplayData3rdParty> returnList = new ArrayList<>();
        for (DatabaseData datum : data) {
            float index = datum.amount;
            String position = Integer.toString(datum.position);
            DisplayData3rdParty dd = new DisplayData3rdParty(index, position);
            returnList.add(dd);
        }
        return returnList;
    }
}
