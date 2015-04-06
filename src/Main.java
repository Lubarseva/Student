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
        System.out.println("Студенты, у которых оценки по экзамену  от 5 до 9: ");
        for (Students st : listStudent1) {
            System.out.println(st.getFullName());
        }
        System.out.println("Студенты, которые сдавали математику: ");
        for (Students st : listStudent2) {
            System.out.println(st.getFullName());
        }
        System.out.println("Студенты, которые получили по английскому  9 и 3: ");
        for (Students st : listStudent3) {
            System.out.println(st.getFullName());
        }

        stud.setSex('1');
        stud.setId(4);
        studentDAO.moveSex(stud);

        exam.setMark(3);
        examDAO.removeStudents(exam);
    }

}
