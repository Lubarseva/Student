package com.lubarseva.student.dao.impl;

import com.lubarseva.student.Connect;
import com.lubarseva.student.bean.Exam;
import com.lubarseva.student.dao.IExamDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Администратор on 06.04.2015.
 */
public class ExamDAO extends Connect implements IExamDAO {

    @Override
    public void removeStudents(Exam exam) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("DELETE FROM test WHERE mark=?");
            stmt.setInt(1, exam.getMark());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
    }
}
