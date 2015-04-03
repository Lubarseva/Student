package com.lubarseva.student.bean;


/**
 * Created by Администратор on 31.03.2015.
 */
public class Subject {
    private int id;
    private String name;
    private Exam exam;

    public Subject() {
    }

    public Subject(int id, String name, Exam exam) {
        this.id = id;
        this.name = name;
        this.exam = exam;
    }

    public Exam getExam() {return exam;}

    public void setExam(Exam exam) {
        this.exam = exam;
    }

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
}
