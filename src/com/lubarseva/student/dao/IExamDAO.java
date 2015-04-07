package com.lubarseva.student.dao;

import com.lubarseva.student.bean.Exam;

import java.util.List;

/**
 * Created by Администратор on 03.04.2015.
 */
public interface IExamDAO {
    public void removeStudentsExam(Exam exam);
    public void insertExam(Exam exam);
    public void updateExam(Exam exam);
    public void selectExam (Exam exam);


}
