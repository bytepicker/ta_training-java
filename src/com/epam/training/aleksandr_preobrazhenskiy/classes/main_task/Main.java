package com.epam.training.aleksandr_preobrazhenskiy.classes.main_task;

import java.util.ArrayList;

import static com.epam.training.aleksandr_preobrazhenskiy.classes.main_task.Helper.*;

public class Main {
    public static void main(String[] args) {
        ArrayList students = new ArrayList<Student>();

        students.add(new Student(0, "Ivan", "Ivanov", "Ivanovich", new Date("1.1.1970"), "Moscow", "212", "Physics", 1, 9031));
        students.add(new Student(1, "Sergey", "Petrov", "Ivanovich", new Date("14.5.1978"), "Voronezh", "345", "Math", 2, 7021));
        students.add(new Student(2, "Alla", "Sidorova", "Sergeevna", new Date("21.11.1976"), "Tver", "235", "Literature", 3, 9031));
        students.add(new Student(3, "Irina", "Popova", "Sergeevna", new Date("11.3.1989"), "Samara", "765", "Languages", 2, 7043));
        students.add(new Student(4, "Vlad", "Lenin", "Ilyich", new Date("12.3.1995"), "Moscow", "357", "Math", 3, 6066));
        students.add(new Student(5, "Mikhail", "Nikolaev", "Ivanovich", new Date("13.7.1954"), "Orel", "978", "Physics", 3, 5025));
        students.add(new Student(6, "Gleb", "Petrov", "Ivanovich", new Date("11.8.1978"), "Saratov", "345", "Math", 2, 6066));
        students.add(new Student(7, "Vera", "Sergeeva", "Sergeevna", new Date("4.10.1989"), "Kemerovo", "457", "Physics", 3, 9031));
        students.add(new Student(8, "Yulia", "Petrova", "Sergeevna", new Date("6.11.1988"), "Moscow", "345", "Languages", 2, 7011));
        students.add(new Student(9, "Ivan", "Sidorov", "Ivanovich", new Date("7.3.1985"), "Samara", "874", "Physics", 1, 7043));
        students.add(new Student(10, "Aleksei", "Romanov", "Ivanovich", new Date("8.8.1990"), "Moscow", "235", "IT", 1, 7031));
        students.add(new Student(11, "Stanislav", "Vasilyev", "Ivanovich", new Date("18.11.1996"), "Pskov", "688", "Physics", 4, 9031));
        students.add(new Student(12, "Egor", "Letov", "Igorevich", new Date("13.10.1967"), "Moscow", "332", "IT", 1, 7043));

        System.out.println("Show all the physics students");
        showStudentsForFaculty(students, "Physics");

        System.out.println("Show all the math students on 2 course");
        showStudentsForFacultyAndCourse(students, "Math", 2);

        System.out.println("Show everyone born after 1990");
        showStudentsBornAfter(students, 1990);

        System.out.println("Show everyone from group 9031");
        showStudentsForGroup(students, 9031);
    }
}
