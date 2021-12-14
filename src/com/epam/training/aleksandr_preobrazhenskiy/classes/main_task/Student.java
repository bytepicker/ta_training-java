package com.epam.training.aleksandr_preobrazhenskiy.classes.main_task;

public class Student {
        private int id;
        private String name;
        private String surname;
        private String middlename;
        private Date birthdate;
        private String address;
        private String phone;
        private String faculty;
        private int course;
        private int group;

        public Student(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Student(int id, String name, String surname, String middlename, Date birthdate, String address, String phone, String faculty, int course, int group) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.middlename = middlename;
            this.birthdate = birthdate;
            this.address = address;
            this.phone = phone;
            this.faculty = faculty;
            this.course = course;
            this.group = group;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getMiddlename() {
            return middlename;
        }

        public Date getBirthdate() {
            return birthdate;
        }

        public String getAddress() {
            return address;
        }

        public String getPhone() {
            return phone;
        }

        public String getFaculty() {
            return faculty;
        }

        public int getCourse() {
            return course;
        }

        public int getGroup() {
            return group;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public void setMiddlename(String middlename) {
            this.middlename = middlename;
        }

        public void setBirthdate(Date birthdate) {
            this.birthdate = birthdate;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setFaculty(String faculty) {
            this.faculty = faculty;
        }

        public void setCourse(int course) {
            this.course = course;
        }

        public void setGroup(int group) {
            this.group = group;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", middlename='" + middlename + '\'' +
                    ", birthdate=" + birthdate +
                    ", address='" + address + '\'' +
                    ", phone='" + phone + '\'' +
                    ", faculty='" + faculty + '\'' +
                    ", course=" + course +
                    ", group=" + group +
                    '}';
        }
    }