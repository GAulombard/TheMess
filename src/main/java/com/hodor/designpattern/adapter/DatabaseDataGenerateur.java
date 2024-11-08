package com.hodor.designpattern.adapter;

import java.util.ArrayList;
import java.util.List;

public class DatabaseDataGenerateur {

    public List<DatabaseData> generateDate() {
        return List.of(
                new DatabaseData(2,2),
                new DatabaseData(3,7),
                new DatabaseData(4,23)
        );
    }
}
