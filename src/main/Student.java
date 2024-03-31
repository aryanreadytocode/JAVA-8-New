package main;

import java.util.List;

public class Student {
    private int id;
    private String firstName;
    private int age;
    private Gender gender;

    public Student(int id, String firstName, int age, Gender gender, Dept dept, String city, int rank, List<String> mobile) {
        this.id = id;
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;
        this.dept = dept;
        this.city = city;
        this.rank = rank;
        this.mobile = mobile;
    }

    private Dept dept;
    private String city;
    private int rank;
    private List<String> mobile;


    enum Gender {
        MALE,
        FEMALE
    }
    enum Dept {
        MECHANIICAL_ENGINEER,
        COMPUTER_ENGINEER,
        ELECTRICAL_ENGINEER,
        CIVIL_ENGINEER,
        ELECTRONIC_ENGINEER
    }
}
