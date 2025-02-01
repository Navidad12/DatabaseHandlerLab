/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.databasehandlerlab;

/**
 *
 * @author Elijah
 */
public class DatabaseHandlerLab {

    public static void main(String[] args) {
        DatabaseConnect data = new DatabaseConnect("students.db");

        data.initializeStudents();
    }
}
