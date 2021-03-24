package com.yrgo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_STUDENT")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
    private String enrollmentID;
    private String name;
    private String tutorName; // This will become a class soon
    @Column (name="NUM_COURSES")
    private Integer numberOfCourses;

    public Student() {}
    
    public Student(String name, String tutorName) {
    	this.name = name;
    	this.tutorName = tutorName;
    }


    public Student(String name) {
    	this.name = name;
    	this.tutorName = null;
    	this.numberOfCourses = 10;
    }
    
    public int getId() {
    	return id;
    }
    
    public void setTutor(String tutor) {
    	this.tutorName= tutor;
    }
    
    public String toString() {
    	return this.name ;
    }

}
