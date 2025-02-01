package com.mycompany.databasehandlerlab;

import java.sql.*;

public class DatabaseConnect {
    private Connection conn;

    public DatabaseConnect(String database) {
        String connStr = "jdbc:sqlite:" + database;
        try {
            conn = DriverManager.getConnection(connStr);
        } catch (SQLException e) {
            System.err.println("Failed to create connection");
            System.err.println(e.toString());
        }
    }

    public void initializeStudents(){
        String qry = "DROP TABLE IF EXISTS Students\r\n" + //
                        "CREATE TABLE Students (\r\n" + //
                        "student_number TEXT NOT NULL,\r\n" + //
                        "student_fname TEXT NOT NULL,\r\n" + //
                        "student_mname TEXT,\r\n" + //
                        "student_lname TEXT NOT NULL,\r\n" + //
                        "student_sex TEXT NOT NULL,\r\n" + //
                        "student_birth TEXT NOT NULL,\r\n" + //
                        "student_start INTEGER NOT NULL,\r\n" + //
                        "student_department TEXT NOT NULL,\r\n" + //
                        "student_units INTEGER NOT NULL,\r\n" + //
                        "student_address TEXT,\r\n" + //
                        "CONSTRAINT Students_PK PRIMARY KEY (student_number)\r\n" + //
                        ");";
                        System.out.println(qry);
    }


}
