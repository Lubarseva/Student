package com.lubarseva.student.dao.impl;

import com.lubarseva.student.Connect;
import com.lubarseva.student.bean.Exam;
import com.lubarseva.student.bean.Students;
import com.lubarseva.student.bean.Subject;
import com.lubarseva.student.dao.IStudentDAO;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Администратор on 06.04.2015.
 */
public class StudentDAO extends Connect implements IStudentDAO {
    @Override
    public List<Students> getMiddleStudent(int first, int last) {
        List<Students> studentList = new ArrayList<Students>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT DISTINCT student.fullName FROM test  INNER JOIN student ON test.studentId=student.id WHERE (test.mark >=? AND test.mark <=?);");
            stmt.setInt(1, first);
            stmt.setInt(2, last);
            rs = stmt.executeQuery();
            Students student = null;
            while (rs.next()) {
                student = new Students();
                student.setFullName(rs.getString("Student.fullName"));
                studentList.add(student);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("SQLConnection Exception. " + e);
        }
        return studentList;

    }

    @Override
    public List<Students> getStudentSubject(Subject subject) {
        List<Students> studentList = new ArrayList<Students>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT DISTINCT student.fullName FROM test  INNER JOIN student ON test.studentId=student.id WHERE (test.subjectId=?);");
            stmt.setInt(1, subject.getId());
            rs = stmt.executeQuery();
            Students student = null;
            while (rs.next()) {
                student = new Students();
                student.setFullName(rs.getString("Student.fullName"));
                studentList.add(student);
            }
            stmt.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("SQLConntection Exception. " + e);
        }
        return studentList;
    }

    @Override
    public List<Students> getStudentEnglish() {
        List<Students> studentList = new ArrayList<Students>();
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT student.fullName FROM test  INNER JOIN student ON test.studentId =student.id WHERE (test.subjectId=3 and (test.mark=9 or test.mark=3))");
            Students student = null;
            while (rs.next()) {
                student = new Students();
                student.setFullName(rs.getString("Student.fullName"));
                studentList.add(student);
            }
            stmt.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("SQLConntection Exception. " + e);
        }
        return studentList;
    }

    @Override
    public void moveSex(Students student) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE student SET sex=? WHERE id=?");
            stmt.setBoolean(1, student.isSex());
            stmt.setInt(2, student.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(Students student) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = getConnection();
//            stmt = conn.prepareStatement("DELETE FROM test  WHERE test.studentId=?");
//            stmt.setInt(1,student.getId());
//            stmt.execute();
            stmt = conn.prepareStatement("DELETE FROM student WHERE id=?");
            stmt.setInt(1, student.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
