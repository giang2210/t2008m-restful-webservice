package com.example.t2008m_restful_webservice.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    private static Connection connection;
    public static Connection getConnection() throws SQLException,ClassNotFoundException{
        Class.forName(Config.DATABASE_DRIVE_CLASS);
        if (connection == null){
            connection =
                    DriverManager.getConnection(Config.DATABASE_URL, Config.DATABASE_USERNAME, Config.DATABASE_PASSWORD);
            System.out.println("Connect success !");
        }else {
            System.out.println("Use existing connection !");
        }
        return connection;
    }
}
