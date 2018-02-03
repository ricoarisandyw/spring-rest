package com.ricoaw.repository;

import com.ricoaw.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by rico on 2/1/2018.
 */

public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByNim(String nim);
    Student findByName(String name);

}
