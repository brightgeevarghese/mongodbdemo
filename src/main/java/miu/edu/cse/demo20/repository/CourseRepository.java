package miu.edu.cse.demo20.repository;

import miu.edu.cse.demo20.model.Course;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CourseRepository extends MongoRepository<Course, ObjectId> {
    Optional<Course> findCourseByCourseCode(String courseCode);
}
