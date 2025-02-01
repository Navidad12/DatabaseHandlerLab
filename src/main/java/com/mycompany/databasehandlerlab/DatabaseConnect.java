package com.mycompany.databasehandlerlab;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnect{
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

    public void initializeStudents() throws SQLException{
        String dropqry = "DROP TABLE IF EXISTS Students;";
        String qry =    "CREATE TABLE Students (\r\n" + 
                        "student_number TEXT NOT NULL,\r\n" + 
                        "student_fname TEXT NOT NULL,\r\n" + 
                        "student_mname TEXT,\r\n" + 
                        "student_lname TEXT NOT NULL,\r\n" + 
                        "student_sex TEXT NOT NULL,\r\n" + 
                        "student_birth TEXT NOT NULL,\r\n" + 
                        "student_start INTEGER NOT NULL,\r\n" + 
                        "student_department TEXT NOT NULL,\r\n" + 
                        "student_units INTEGER NOT NULL,\r\n" + 
                        "student_address TEXT,\r\n" + 
                        "CONSTRAINT Students_PK PRIMARY KEY (student_number)\r\n" + 
                        ");";
        PreparedStatement dropstmt = conn.prepareStatement(dropqry);
        dropstmt.executeUpdate();
        PreparedStatement pstmt = conn.prepareStatement(qry);
        pstmt.executeUpdate();
    }

    public Student getStudents(String student_id) throws SQLException {
        String qry = "SELECT * FROM Students WHERE student_number = ?";
        PreparedStatement pstmt = conn.prepareStatement(qry);
        pstmt.setString(1, student_id);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            return new Student(rs.getString("student_number"), 
                                rs.getString("student_fname"), 
                                rs.getString("student_mname"),
                                rs.getString("student_lname"),
                                rs.getString("student_sex"),
                                rs.getString("student_birth"),
                                rs.getInt("student_start"),
                                rs.getString("student_department"),
                                rs.getInt("student_units"),
                                rs.getString("student_address")
                                );
        }else{
            return null;
        }        
    }
    public Student getStudent(String student_Fname, String student_Mname, String student_Lname) throws SQLException{
        String qry = "SELECT * FROM Students \r\n" + 
                        "WHERE student_fname = ?\r\n" +
                        "AND student_mname = ?\r\n" + 
                        "AND student_lname = ?";
        PreparedStatement pstmt = conn.prepareStatement(qry);
        pstmt.setString(1, student_Fname);
        pstmt.setString(2, student_Mname);
        pstmt.setString(3, student_Lname);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            return new Student(rs.getString("student_number"), 
                                rs.getString("student_fname"), 
                                rs.getString("student_mname"),
                                rs.getString("student_lname"),
                                rs.getString("student_sex"),
                                rs.getString("student_birth"),
                                rs.getInt("student_start"),
                                rs.getString("student_department"),
                                rs.getInt("student_units"),
                                rs.getString("student_address")
                                );
        }else{
            return null;
        }        
    }

    public ArrayList<Student> getStudents()throws SQLException{
        String qry = "SELECT * FROM Students";
        ArrayList<Student> studs = new ArrayList<>();
        PreparedStatement pstmt = conn.prepareStatement(qry);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            studs.add(new Student(rs.getString("student_number"), 
                                    rs.getString("student_fname"), 
                                    rs.getString("student_mname"),
                                    rs.getString("student_lname"),
                                    rs.getString("student_sex"),
                                    rs.getString("student_birth"),
                                    rs.getInt("student_start"),
                                    rs.getString("student_department"),
                                    rs.getInt("student_units"),
                                    rs.getString("student_address")
                                    ));
        }
        return studs;
    }

    public Boolean removeStudent(String studentNumber) throws SQLException{
        String qry = "DELETE FROM Students \r\n" + //
                        "WHERE student_number = ?";
        PreparedStatement pstmt = conn.prepareStatement(qry);
        pstmt.setString(1, studentNumber);
        return pstmt.executeUpdate() > 0;
    }

    public Boolean getStudentByYear(int year) throws SQLException{
        String qry = "SELECT * FROM Students \r\n" + //
                    "WHERE student_start LIKE ?";
        PreparedStatement pstmt = conn.prepareStatement(qry);
        pstmt.setInt(1, year);
        ResultSet rs = pstmt.executeQuery();
        return rs.next();       
    }

    public Boolean updateStudentInfo(String studentNumber, Student studentInfo) throws SQLException{
        String qry = "UPDATE Students \r\n" + //
                        "SET student_fname = ?\r\n" + //
                        ", student_mname = ?\r\n" + //
                        ", student_lname = ?\r\n" + //
                        ", student_department = ?\r\n" + //
                        ", student_address = ?\r\n" + //
                        "WHERE student_number = ?";
        PreparedStatement pstmt = conn.prepareStatement(qry);
        pstmt.setString(1, studentInfo.getFirstName());
        pstmt.setString(2, studentInfo.getMiddleName());
        pstmt.setString(3, studentInfo.getLastName());
        pstmt.setString(4, studentInfo.getDepartment());
        pstmt.setString(5, studentInfo.getAddress());
        pstmt.setString(6, studentNumber);
        return pstmt.executeUpdate() > 0;
    }

    public Boolean updateStudentUnits(int subtractedUnits, String studentNumber) throws SQLException{
        String qry = "UPDATE Students \r\n" + //
                        "SET student_units = ?\r\n" + //
                        "WHERE student_number = ?";
        PreparedStatement pstmt = conn.prepareStatement(qry);
        pstmt.setInt(1, subtractedUnits);
        pstmt.setString(2, studentNumber);
        return pstmt.executeUpdate() > 0;
    }

    public boolean insertStudent(Student newStudent) throws SQLException{
        String qry = "INSERT INTO Students (\r\n" + //
                        "student_number\r\n" + //
                        ", student_fname\r\n" + //
                        ", student_mname\r\n" + //
                        ", student_lname\r\n" + //
                        ", student_sex\r\n" + //
                        ", student_birth\r\n" + //
                        ", student_start\r\n" + //
                        ", student_department\r\n" + //
                        ", student_units\r\n" + //
                        ", student_address\r\n" + //
                        ") values (\r\n" + //
                        "?\r\n" + //
                        ", ?\r\n" + //
                        ", ?\r\n" + //
                        ", ?\r\n" + //
                        ", ?\r\n" + //
                        ", ?\r\n" + //
                        ", ?\r\n" + //
                        ", ?\r\n" + //
                        ", ?\r\n" + //
                        ", ?\r\n" + //
                        ")";
            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setString(1, newStudent.getStudentId()); pstmt.setString(2, newStudent.getFirstName());
            pstmt.setString(3, newStudent.getMiddleName()); pstmt.setString(4, newStudent.getLastName());
            pstmt.setString(5, newStudent.getSex()); pstmt.setString(6, newStudent.getBirthDate());
            pstmt.setInt(7, newStudent.getStartYear()); pstmt.setString(8, newStudent.getDepartment());
            pstmt.setInt(9, newStudent.getUnits()); pstmt.setString(10, newStudent.getAddress());
            return pstmt.executeUpdate() > 0;

    }
    public static class Student {
        private String student_id;
        private String student_Fname;
        private String student_Mname;
        private String student_Lname;
        private String student_sex;
        private String student_birth;
        private int student_start;
        private String student_department;
        private int student_units;
        private String student_address;
        
        Student(String student_id, String student_Fname, String student_Mname, String student_Lname, String student_sex, String student_birth,
                int student_start, String student_department, int student_units, String student_address) {
                    this.student_id = student_id;
                    this.student_Fname = student_Fname;
                    this.student_Mname = student_Mname;
                    this.student_Lname = student_Lname;
                    this.student_sex = student_sex;
                    this.student_birth = student_birth;
                    this.student_start = student_start;
                    this.student_units = student_units;
                    this.student_address = student_address;
                    this.student_department = student_department;
        }

        public String getStudentId() { return student_id; }
        public String getFirstName() { return student_Fname; }
        public String getMiddleName() { return student_Mname; }
        public String getLastName() { return student_Lname; }
        public String getSex() { return student_sex; }
        public String getBirthDate() { return student_birth; }
        public int getStartYear() { return student_start; }
        public String getDepartment() { return student_department; }
        public int getUnits() { return student_units; }
        public String getAddress() { return student_address; }
        
    }

}