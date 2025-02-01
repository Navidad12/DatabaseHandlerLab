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
        DatabaseConnect data = new DatabaseConnect("students.db");
        data.initializeStudents();

        DatabaseConnect.Student stud = new DatabaseConnect.Student("20230101234", "Karl", "Sotto", "Mapagmahal", "M", "2001-01-01", 2024, "CICS", 26, "Novaliches");
        data.insertStudent(stud);
        
        data.getStudents("20230101234");

        data.getStudent("Karl", "Sotto", "Mapagmahal");

        data.getStudents();

        data.removeStudent("20230101234");

        data.getStudentByYear(2024);

        DatabaseConnect.Student stud2 = new DatabaseConnect.Student("20230101234", "Elijah", "Miguel", "Gabriel", "M", "2001-01-01", 2024, "Faculty of Nursing", 26, "BGC");
        data.updateStudentInfo("20230101234", stud2);

        data.updateStudentUnits(15, "20230101234");
    }
}
