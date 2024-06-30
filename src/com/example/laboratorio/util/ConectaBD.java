package com.example.laboratorio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBD {
     private final String URL = "jdbc:mysql://localhost:3308/biblioteca";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String USER = "root";
    private final String PASS = "";

    public Connection getConexion() throws SQLException {
        Connection cn = null;
        try {
            Class.forName(DRIVER).newInstance();
            cn = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return cn;
    }
}
