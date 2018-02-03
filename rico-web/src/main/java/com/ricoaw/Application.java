package com.ricoaw;

import com.ricoaw.entity.Student;
import com.ricoaw.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

/**
 * Created by rico on 2/1/2018.
 */
@SpringBootApplication
@EntityScan("com.ricoaw")
@ComponentScan("com.ricoaw")
@EnableAutoConfiguration
public class Application implements CommandLineRunner{

    @Autowired
    StudentRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        repository.save(new Student("Rico","12","X"));

        List<Student> students = repository.findAll();
        for (Student s:students)
            System.out.println(s.toString());
    }
}
