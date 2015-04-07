package com.lubarseva.student.dao.impl;

import com.lubarseva.student.Connect;
import com.lubarseva.student.bean.Exam;
import com.lubarseva.student.bean.Students;
import com.lubarseva.student.bean.Subject;
import com.lubarseva.student.dao.IExamDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 06.04.2015.
 */
public class ExamDAO extends Connect implements IExamDAO {

    @Override
    public void removeStudentsExam(Exam exam) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("DELETE FROM test WHERE (mark=? <= 4)");
            stmt.setInt(1, exam.getMark());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertExam(Exam exam) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO  test (subjectId, studentId, mark)  VALUES (?,?,?)");
            stmt.setInt(1, exam.getSubjectId());
            stmt.setInt(2, exam.getStudentId());
            stmt.setInt(3, exam.getMark());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("SQLConnection Exception. " + e);
        }
    }

    @Override
    public void updateExam(Exam exam) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE test SET mark=? WHERE test.studentId=?");
            stmt.setInt(1, exam.getMark());
            stmt.setInt(2, exam.getStudentId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLConnection Exception. " + e);
        }
    }

    @Override
    public void selectExam(Exam exam) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT test.mark FROM test WHERE (test.studentId=?);");
            stmt.setInt(1, exam.getStudentId());
            rs = stmt.executeQuery();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("SQLConntection Exception. " + e);
        }
    }


}
