package org.example.MyIo.service.impl;

import org.example.MyIo.base.service.impl.BaseServiceImpl;
import org.example.MyIo.domain.Student;
import org.example.MyIo.repository.StudentRepository;
import org.example.MyIo.service.StudentService;

public class StudentServiceImpl
        extends BaseServiceImpl<Student, Long, StudentRepository>
        implements StudentService {
    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }
}
