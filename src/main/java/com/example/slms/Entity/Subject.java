package com.example.slms.Entity;

import com.example.slms.Enums.SubjectCategoryEnum;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import javax.persistence.*;
import java.util.List;

@Entity
@JsonNaming( value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue( strategy =  GenerationType.AUTO)
    @Column( name = "Subject_ID" )
    private int subjectID;

    @Column( name = "Subject_Name" )
    private String subjectName;

    @Column( name = "Credit_Value" )
    private float creditValue;

    @Enumerated(EnumType.STRING)
    @Column( name = "Subject_Category" )
    private SubjectCategoryEnum subjectCategory;

    @OneToMany( mappedBy = "subject")
    private List<Student> studentList;

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public float getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(float creditValue) {
        this.creditValue = creditValue;
    }

    public SubjectCategoryEnum getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(SubjectCategoryEnum subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
