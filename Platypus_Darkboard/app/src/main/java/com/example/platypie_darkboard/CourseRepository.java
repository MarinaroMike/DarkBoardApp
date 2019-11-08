package com.example.platypie_darkboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* Singleton Repository for all courses and coure information

    Michael Marinaro November 2019
 */

public class CourseRepository {

    private static CourseRepository repository = null;

    private List<Course> courseList;

    Random r = new Random();

    private CourseRepository(){
        courseList = test();
//        sortInit(courseList); //TODO: Remove this test.
    }

    public static CourseRepository getInstance(){
        if (repository == null)
            repository = new CourseRepository();

        return repository;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courses) {
        courseList = courses;
    }

    public void addCourse(Course course){
        courseList.add(course);
    }

//    public void sortInit(List<Course> cList){
//        Collections.sort(cList, new CourseComparator());
//    }

    //TEST LIST
    //Random Grade for testing
    public double randomGrade() {
        double next = (double) r.nextDouble();

        double grade = 60 + (next*40);
        return grade;
    }

    private List<Course> test(){
        List<Course> testCourses = new ArrayList<>();

        testCourses.add(new Course ("Intro to Darkboard", "DB04315", "Algernon Blackwood", r.nextInt(4) +1, randomGrade(), "M/W 06:30 - 07:45 PM Science Bldg 254"));
        testCourses.add(new Course ("Advanced Platypus Anatomy", "DB07340", "Philip Lovecraft", r.nextInt(4) +1, randomGrade(), "T/R 12:30- 01:45 PM Business Hall 101"));
        testCourses.add(new Course ("Design and Analysis of Platypie", "CS07432", "Robert Howard", r.nextInt(4) +1, randomGrade(), "M/W 02:00- 03:15 PM Business Hall 105"));
        testCourses.add(new Course ("Platypus Handling", "BI08200", "Dan Simmons", r.nextInt(4) +1, randomGrade(), "F 02:00 PM - 03:15 PM James Hall 2098"));
        testCourses.add(new Course ("Discrete Platypie", "CS04530", "John Milton", r.nextInt(4) +1, randomGrade(), "Online"));


        return testCourses;
    }
}
