package com.lubarseva.student.dao;

import com.lubarseva.student.bean.Students;
import com.lubarseva.student.bean.Subject;

import java.util.List;

/**
 * Created by on 03.04.2015.
 */
public interface ISubjectDAO {
    public void insertSubject(Subject subject);
    public void deleteSubject(Subject subject);
    public  List<Subject> selectExam(Subject subject, int highMark);
    public List<Subject> getSubjectA(Subject subject);
    public void updateSubject(Subject subject);
}
