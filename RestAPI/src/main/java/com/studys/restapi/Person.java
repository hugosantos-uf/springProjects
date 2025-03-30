package com.studys.restapi;

import java.util.List;

public class Person {
    private String name;
    private int age;
    private String email;
    private boolean isStudent;
    private List<String> courses;

    public Person(String name, int age, String email, boolean isStudent, List<String> courses) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isStudent = isStudent;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}


