package com.lubarseva.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Администратор on 06.04.2015.
 */
public class Connect {

    private Connection conn = null;

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if(conn== null)
                conn = DriverManager.getConnection("jdbc:mysql://localhost/university?user=root&password=root");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return conn;
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
