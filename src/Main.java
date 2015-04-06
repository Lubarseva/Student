import com.lubarseva.student.bean.Exam;
import com.lubarseva.student.bean.Students;
import com.lubarseva.student.bean.Subject;
import com.lubarseva.student.dao.impl.ExamDAO;
import com.lubarseva.student.dao.impl.StudentDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created b on 31.03.2015.
 */
public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        ExamDAO examDAO = new ExamDAO();

        Students stud = new Students();
        Exam exam = new Exam();

        List<Students> listStudent1 = studentDAO.getMiddleStudent();
        List<Students> listStudent2 = studentDAO.getStudentMAth();
        List<Students> listStudent3 = studentDAO.getStudentEnlish();
        System.out.println("Students who assess exam 5 to 9: ");
        for (Students st : listStudent1) {
            System.out.println(st.getFullName());
        }
        System.out.println("Students who have passed the math: ");
        for (Students st : listStudent2) {
            System.out.println(st.getFullName());
        }
        System.out.println("Students who have received english 9 and 3: ");
        for (Students st : listStudent3) {
            System.out.println(st.getFullName());
        }

        stud.setSex(true);
        stud.setId(4);
        studentDAO.moveSex(stud);

        exam.setMark(3);
        examDAO.removeStudents(exam);
        examDAO.closeConnection();
    }

}
