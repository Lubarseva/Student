package com.lubarseva.student.dao;

import java.util.List;

import com.lubarseva.student.bean.Exam;
import com.lubarseva.student.bean.Students;
import com.lubarseva.student.bean.Subject;

/**
 * Created by Администратор on 03.04.2015.
 */
public interface IStudentDAO {
    public List<Students> getMiddleStudent(int first, int last);
    public List<Students> getStudentSubject(Subject subject);
    public List<Students> getStudentEnglish();
    public void moveSex(Students student);
    public void deleteStudent(Students student);


}
