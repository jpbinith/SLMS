package com.example.slms.Entity;

import com.example.slms.Enums.GenderEnum;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;

@Entity
@JsonNaming( value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Student_ID")
    private int studentID;

    @Column(name = "Firstname")
    private String firstName;

    @Column(name = "Lastname")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "Gender")
    private GenderEnum gender;

    @Column(name = "Grade")
    private String grade;

    @ManyToOne
    @JoinColumn(name = "Subject_ID")
    private Subject subject;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
