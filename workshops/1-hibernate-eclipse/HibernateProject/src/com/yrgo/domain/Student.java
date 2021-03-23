package com.yrgo.domain;


public class Student
{
    private String enrollmentID;
    private String name;
    private String tutorName; // This will become a class soon


    public Student(String name, String tutorName)
    {
    	this.name = name;
    	this.tutorName = tutorName;
    }


    public Student(String name)
    {
    	this.name = name;
    	this.tutorName = null;
    }

}
