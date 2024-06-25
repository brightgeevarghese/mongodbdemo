package miu.edu.cse.demo20.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "courses")
@Getter
@Setter
public class Course {
    @Id
    private ObjectId id;
    private String courseName;
    private String courseCode;
    @DBRef
    private List<Student> students;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }
}
