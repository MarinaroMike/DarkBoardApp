package com.example.platypie_darkboard;

/*  Course class
        All Courses:
  	    - Have a Name, CRN, Professor, Meeting Time & Day, Section, GradeList, and Total Grade

    Michael Marinaro November 2019
 */


public class Course {

    String name;
    String CRN;
    String prof;

    String meetingTime;
    //Array<float> gradeList
    double totalGrade;
    int section;

    public Course(String name, String CRN, String prof, int section, double grade, String meetingTime ) {
        this.name = name;
        this.CRN = CRN;
        this.prof = prof;
        this.totalGrade = grade;
        this.section = section;
        this.meetingTime = meetingTime;
    }



    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCRN() {
        return CRN;
    }

    public void setCRN(String CRN) {
        this.CRN = CRN;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public double getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(float totalGrade) {
        this.totalGrade = totalGrade;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime;
    }
}
