import com.lubarseva.student.bean.Exam;
import com.lubarseva.student.bean.Students;
import com.lubarseva.student.bean.Subject;
import com.lubarseva.student.dao.impl.ExamDAO;
import com.lubarseva.student.dao.impl.StudentDAO;
import com.lubarseva.student.dao.impl.SubjectDAO;

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
        int first = 5;
        int last = 8;
        StudentDAO studentDAO = new StudentDAO();
        ExamDAO examDAO = new ExamDAO();
        SubjectDAO subjectDAO = new SubjectDAO();

        Students stud = new Students();
        Exam exam = new Exam();
        Subject subject = new Subject();


        subject.setId(1);
        List<Students> listStudent1 = studentDAO.getMiddleStudent(first, last);
        List<Students> listStudent2 = studentDAO.getStudentSubject(subject);
        List<Students> listStudent3 = studentDAO.getStudentEnglish();

        System.out.println("Students who assess exam " + first + " to " + last + ": ");
        for (Students st : listStudent1) {
            System.out.println(st.getFullName());
        }
        System.out.println("Students who have passed : ");
        for (Students st : listStudent2) {
            System.out.println(st.getFullName());
        }
        System.out.println("Students who have received english 9 and 3: ");
        for (Students st : listStudent3) {
            System.out.println(st.getFullName());
        }
        //sex change
        stud.setSex(true);
        stud.setId(3);
        studentDAO.moveSex(stud);

        //delete student
        stud.setId(3);
        studentDAO.deleteStudent(stud);

        //removal of a student who has to go to resit
        exam.setMark(3);
        examDAO.removeStudentsExam(exam);

        //adding a student who passed the exam
        exam.setSubjectId(3);
        exam.setStudentId(3);
        exam.setMark(9);
        examDAO.insertExam(exam);

        //mark of student
        exam.setStudentId(4);
        examDAO.selectExam(exam);

        //insert subject
        subject.setName("Экономика");
        subjectDAO.insertSubject(subject);

        //delete subject
        subject.setId(1);
        subjectDAO.deleteSubject(subject);
        subjectDAO.closeConnection();



    }

}
