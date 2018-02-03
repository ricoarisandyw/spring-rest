package com.ricoaw;

import com.ricoaw.entity.Student;
import com.ricoaw.entity.StudentDto;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rico on 2/1/2018.
 */
@Component
public class StudentAssembler implements Assembler<Student,StudentDto> {
    @Nonnull
    @Override
    public Student fromDto(@Nonnull StudentDto dto) {
        return null;
    }

    @Nonnull
    @Override
    public List<Student> fromDto(@Nonnull List<StudentDto> list) {
        return null;
    }

    @Nonnull
    @Override
    public StudentDto fromEntity(@Nonnull Student entity) {
        StudentDto studentDto = new StudentDto();
        studentDto.setName(entity.getName());
        studentDto.setId(entity.getId());
        return studentDto;
    }

    @Nonnull
    @Override
    public List<StudentDto> fromEntity(@Nonnull List<Student> entity) {
        return entity.stream().map(this::fromEntity).collect(Collectors.toList());
    }
}
