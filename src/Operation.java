
import com.lubarseva.student.bean.Exam;
import com.lubarseva.student.bean.Students;
import com.lubarseva.student.bean.Subject;
import com.lubarseva.student.dao.IStudentDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ������������� on 31.03.2015.
 */
public class Operation extends Connect implements IStudentDAO {

    public List<Students> getMiddleStudent() {
        List<Students> studentList = new ArrayList<Students>();
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT student.fullName FROM test  INNER JOIN student ON test.id_student=student.id WHERE (test.mark >= 5 AND test.mark <=9);");
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

    public List<Students> getStudentMAth() {
        List<Students> studentList = new ArrayList<Students>();
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT student.fullName FROM test  INNER JOIN student ON test.id_student=student.id WHERE (test.id_subject=1);");
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

    public void moveSex(Students student) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE student SET sex=? WHERE id=4");
            stmt.setString(1,new String( new String(new char[]{student.getSex()})));
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally

        {
            closeConnection();
        }
    }
    public void removeStudents(Exam exam) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("DELETE FROM test WHERE mark=? ");
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

    public List<Students> getStudentEnlish() {
        List<Students> studentList = new ArrayList<Students>();
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT student.fullName FROM test  INNER JOIN student ON test.id_student=student.id WHERE (test.id_subject=3 and (test.mark=9 or test.mark=3));");
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
}