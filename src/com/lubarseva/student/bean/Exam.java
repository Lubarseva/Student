package com.lubarseva.student.bean;

/**
 * Created by Администратор on 31.03.2015.
 */
public class Exam {
    private int id;
    private int studentId;
    private int subjectId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    private int mark;

    public Exam() {
    }

    public Exam(int id, int  studentId, int subjectId, int mark) {
        this.id = id;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

}
