package com.hito.nikolay.lessons_1_utkin;

public class Student {
    public int id;
    private String name;
    private String surname;
    private String grade;
    private int birthdayYear;

    public Student(String inputData)
    {
        String[] parts = inputData.split(" ");

        id = (int) System.currentTimeMillis();
        name = parts[0];
        surname = parts[1];
        grade = parts[2];
        birthdayYear = Integer.parseInt(parts[3]);
    }

    @Override
    public String toString()
    {
        return id + " " + name + " "+ surname + " " + grade + " " + birthdayYear;
    }
}
