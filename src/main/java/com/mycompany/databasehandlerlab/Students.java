package com.mycompany.databasehandlerlab;

public class Students {
    private String stud_ID;
    private String stud_Fname;
    private String stud_Mname;
    private String stud_Lname;
    private char stud_sex;
    private String stud_birth;
    private int stud_start;
    private int stud_units;
    private String stud_addr;
    
    Students(String stud_ID, String stud_Fname, String stud_Mname, String stud_Lname, char stud_sex, String stud_birth,
            int stud_start, int stud_units, String addr) {
                this.stud_ID = stud_ID;
                this.stud_Fname = stud_Fname;
                this.stud_Mname = stud_Mname;
                this.stud_Lname = stud_Lname;
                this.stud_sex = stud_sex;
                this.stud_birth = stud_birth;
                this.stud_start = stud_start;
                this.stud_units = stud_units;
                this.stud_addr = addr;
    }
    
}
