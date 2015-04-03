package com.lubarseva.student.bean;

/**
 * Created by Администратор on 31.03.2015.
 */
public class Exam {
    private int id;
    private int id_student;
    private int id_subject;
    private int mark;

    public Exam() {
    }

    public Exam(int id, int id_student, int id_subject, int mark) {
        this.id = id;
        this.id_student = id_student;
        this.id_subject = id_subject;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

}
