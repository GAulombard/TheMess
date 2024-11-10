package com.hodor.jdbc.implementationwithhibernateorm;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class DataSourceProvider {

    private static BasicDataSource instance;

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new BasicDataSource();
            instance.setInitialSize(5); // nbr de pools
            instance.setUrl("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris");
            instance.setUsername("root");
            instance.setPassword("rootroot");
        }
        return instance;
    }
}
