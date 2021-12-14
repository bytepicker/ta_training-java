package com.epam.training.aleksandr_preobrazhenskiy.classes.main_task;

import java.util.ArrayList;

public class Helper {
    public static void showStudentsForFaculty(ArrayList<Student> students, String faculty) {
        students.stream().filter(e -> e.getFaculty().equals(faculty)).forEach(System.out::println);
    }

    public static void showStudentsForFacultyAndCourse(ArrayList<Student> students, String faculty, int course) {
        students.stream().filter(e -> e.getFaculty().equals(faculty) && e.getCourse() == course).forEach(System.out::println);
    }

    public static void showStudentsBornAfter(ArrayList<Student> students, int year) {
        students.stream().filter(e -> e.getBirthdate().getYyyy() > year).forEach(System.out::println);
    }

    public static void showStudentsForGroup(ArrayList<Student> students, int group) {
        students.stream().filter(e -> e.getGroup() == group).forEach(System.out::println);
    }
}