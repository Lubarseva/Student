package com.lubarseva.student.dao.impl;

import com.lubarseva.student.Connect;
import com.lubarseva.student.bean.Exam;
import com.lubarseva.student.bean.Students;
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
    public List<Students> getMiddleStudent() {
        List<Students> studentList = new ArrayList<Students>();
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT student.fullName FROM test  INNER JOIN student ON test.studentId=student.id WHERE (test.mark >= 5 AND test.mark <=9);");
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
        } finally {
            closeConnection();
        }
        return studentList;

    }

    @Override
    public List<Students> getStudentMAth() {
        List<Students> studentList = new ArrayList<Students>();
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT student.fullName FROM test  INNER JOIN student ON test.studentId=student.id WHERE (test.subjectId=1);");
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
        } finally {
            closeConnection();
        }
        return studentList;
    }

    @Override
    public List<Students> getStudentEnlish() {
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
        } finally {
            closeConnection();
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
            stmt.setString(1, new String(new char[]{student.getSex()}));
            stmt.setInt(2, student.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }


}
