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
        DatabaseConnect.Student stud = new DatabaseConnect.Student("20293021", "Karl", "Sotto", "Mapagmahal", "M", "2001-01-01", 2024, "CICS", 26, "Novaliches");
        data.insetStudent(stud);
    }
}
