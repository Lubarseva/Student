import com.lubarseva.student.bean.Exam;
import com.lubarseva.student.bean.Students;
import com.lubarseva.student.bean.Subject;

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
        Operation operation = new Operation();
        Students stud = new  Students();
        Exam exam = new Exam();
        List<Students> listStudent1 = operation.getMiddleStudent();
        List<Students> listStudent2 = operation.getStudentMAth();
        List<Students> listStudent3 = operation.getStudentEnlish();
        System.out.println("Студенты, у которых оценки по экзамену  от 5 до 8: ");
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
        stud.setSex('м');
        operation.moveSex(stud);

        exam.setMark(3);
        operation.removeStudents(exam);
    }

}
