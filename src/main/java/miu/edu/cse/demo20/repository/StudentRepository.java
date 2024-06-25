package miu.edu.cse.demo20.repository;

import miu.edu.cse.demo20.model.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, ObjectId> {
    Optional<Student> findStudentByFirstNameAndLastName(String firstName, String lastName);
}
