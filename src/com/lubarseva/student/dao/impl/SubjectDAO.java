package com.lubarseva.student.dao.impl;

import com.lubarseva.student.Connect;
import com.lubarseva.student.bean.Students;
import com.lubarseva.student.bean.Subject;
import com.lubarseva.student.dao.ISubjectDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 06.04.2015.
 */
public class SubjectDAO extends Connect implements ISubjectDAO {

    @Override
    public void insertSubject(Subject subject) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO  subject (subj) VALUES (?)");
            stmt.setString(1, subject.getName());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("SQLConnection Exception. " + e);
        }
    }

    @Override
    public void deleteSubject(Subject subject) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("DELETE FROM subject WHERE (id=?)");
            stmt.setInt(1, subject.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("SQLConnection Exception. " + e);
        }
    }


    @Override
    public List<Subject> getSubjectA(Subject subject) {
        List<Subject>  subjectList = new ArrayList<Subject>();
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT subject.subj FROM subject  WHERE subj LIKE 'А%'");
            Subject student = null;
            while (rs.next()) {
                subject = new Subject();
                subject.setName(rs.getString("Subject.name"));
                subjectList.add(subject);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("SQLConnection Exception. " + e);
        }
        return subjectList;
    }

    @Override
    public void updateSubject(Subject subject) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE student SET subj=? WHERE id=?");
            stmt.setString(1, subject.getName());
            stmt.setInt(2, subject.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLConnection Exception. " + e);
        }

    }
    @Override
    public  List<Subject> selectExam(Subject subject, int highMark) {
        List<Subject> subjectList = new ArrayList<Subject>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT DISTINCT subject.subj FROM test  INNER JOIN subject ON test.subjectId =subject.id WHERE (test.mark=?)");
            stmt.setInt(1, highMark);
            rs = stmt.executeQuery();
            while (rs.next()) {
                subject = new Subject();
                subject.setName(rs.getString("Subject.name"));
                subjectList.add(subject);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("SQLConnection Exception. " + e);
        }
        return subjectList;
    }

}
