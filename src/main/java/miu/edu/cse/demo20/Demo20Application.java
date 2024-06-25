package miu.edu.cse.demo20;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.demo20.model.Course;
import miu.edu.cse.demo20.model.Student;
import miu.edu.cse.demo20.repository.CourseRepository;
import miu.edu.cse.demo20.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class Demo20Application {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Demo20Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            //Create Students
            Student student1 = new Student("Joy", "Mathew");
            Student student2 = new Student("Tom", "Jerry");
            //Save Students
            System.out.println(
                    studentRepository.save(student1).getFirstName() + " & "
                            + studentRepository.save(student2).getFirstName()
                    + " are saved"
            );
            //Create Courses
            Course course1 = new Course("ASD", "CS489");
            Course course2 = new Course("MPP", "CS401");
            //Set students to courses
            course1.setStudents(List.of(student1, student2));
            course2.setStudents(List.of(student1, student2));
            System.out.println(
                    courseRepository.save(course1).getCourseCode() + " and " +
                            courseRepository.save(course2).getCourseCode() +
                                    " are saved"
            );
            //Set courses to students
            student1.setCourses(List.of(course1, course2));
            student2.setCourses(List.of(course1, course2));
            //Save Courses
            System.out.println(
                    studentRepository.save(student1).getFirstName() + " & " + studentRepository.save(student2).getFirstName() +
                            " are saved."
            );
        };
    }
}
