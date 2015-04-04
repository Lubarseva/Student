package com.lubarseva.student.dao;

import java.util.List;

import com.lubarseva.student.bean.Exam;
import com.lubarseva.student.bean.Students;
/**
 * Created by Администратор on 03.04.2015.
 */
public interface IStudentDAO {
    public List<Students> getMiddleStudent();
    public List<Students> getStudentMAth();
    public List<Students> getStudentEnlish();
    public void moveSex(Students student);
    public void removeStudents(Exam exam);

}
