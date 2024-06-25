package miu.edu.cse.demo20.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "students")
@Getter
@Setter
public class Student {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    @DBRef
    private List<Course> courses;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
