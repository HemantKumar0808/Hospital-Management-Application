package com.jpahibernate.Student_Management_DB.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // --> it represents that this class is entity or model class which is directly creating the database table or schema
@Table(name = "student") // --> // it will create a table inside database
public class Student {

    @Id // it is the primary key of the table - it will be unique and it is not null
    @Column(name="id") // it will create a column inside database table
    private int id;

    @Column(name="student_name", nullable = false) // nullable = false - it cannot contain null value
    private String name;

    @Column(name="email", nullable = false, unique = true) // unique=true - it cannot contain duplicated value
    private String email;

    @Column(name="dob", nullable = false)
    private String dob;

    @Column(name="gender",nullable = false)
    private String gender;

    @Column(name="grade",nullable = false)
    private String grade;

    @Column(name="mobile",nullable = false,unique = true)
    private String mobile_no;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
}
