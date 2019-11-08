package com.example.platypie_darkboard;

/*  ViewModel to draw info from courses and populate course cards

    Michael Marinaro November 2019
 */


public class ViewModel {
    private Course course;
    private Manager manager;
    private CourseRepository repository = CourseRepository.getInstance();

    public ViewModel(Manager manager) {
        this.manager = manager;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getName() {
        return course.getName();
    }

    public String getProf() {
        return course.getProf();
    }

    public String getCRN() { return course.getCRN(); }

    public String getMeetingTime() { return course.getMeetingTime(); }

    public String getTotalGrade() {
        String sub = Double.toString(course.getTotalGrade());
        return sub.substring(0,5);
    }

    public String getSection() { return "Section " + (course.getSection()); }

    public int getTotalGradePerc() { return (int)course.getTotalGrade();}

}
