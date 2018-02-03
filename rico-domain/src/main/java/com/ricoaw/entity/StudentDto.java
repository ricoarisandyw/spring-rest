package com.ricoaw.entity;

import iconpln.common.util.Check;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * Created by rico on 2/1/2018.
 */
public class StudentDto implements Serializable{

    String id;
    String name;
//    String grade;
//    String nim;

    public StudentDto(){
    }

    public StudentDto(@Nonnull String id, @Nonnull String name) {
        Check.nonNull(id, "ModelId required!");
        Check.hasText(name, "Name required!");
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
