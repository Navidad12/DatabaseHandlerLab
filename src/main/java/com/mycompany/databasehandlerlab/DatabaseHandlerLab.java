/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.databasehandlerlab;

import java.sql.SQLException;

/**
 *
 * @author Elijah
 */
public class DatabaseHandlerLab {

    public static void main(String[] args) throws SQLException{
        String ID = "20230101234"; String Fname = "Karl"; String Mname = "Sotto"; String Lname = "Mapagmahal";
        String sex = "M"; String date = "2001-01-01"; int startyear = 2023; String dept = "CICS";
        int units = 26; String address = "Novaliches";
        DatabaseConnect data = new DatabaseConnect("students.db");
        data.initializeStudents();

        DatabaseConnect.Student stud = new DatabaseConnect.Student("20230101234", "Karl", "Sotto", "Mapagmahal", "M", "2001-01-01", 2024, "CICS", 26, "Novaliches");
        data.insertStudent(stud);
        
        data.removeStudent("20230101234");

        data.getStudentByYear(2024);
    }
}
