package com.lubarseva.student.bean;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

/**
 * Created by Администратор on 31.03.2015.
 */
public class Students {
    private int id;
    private String fullName;
    private Date date;
    private char sex;
    private List<Subject> subjectList = new ArrayList<Subject>();

    public Students() {
    }

    public Students(int id, String fullName, List<Subject> subjectList) {
        this.id = id;
        this.fullName = fullName;
        this.subjectList = subjectList;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
