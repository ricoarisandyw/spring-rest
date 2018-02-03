package com.ricoaw.entity;

import javax.persistence.*;

/**
 * Created by rico on 2/1/2018.
 */
@Entity
public class Student extends BaseModel{

    @Column(nullable = false,length = 100)
    String name;

    @Column(nullable = false,length = 10)
    String nim;

    @Column(nullable = false,length = 2)
    String grade;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + getId() +
                ", name='" + name + '\'' +
                ", nim='" + nim + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
