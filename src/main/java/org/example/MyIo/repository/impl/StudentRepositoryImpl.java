package org.example.MyIo.repository.impl;

import org.example.MyIo.base.repository.impl.BaseRepositoryImpl;
import org.example.MyIo.domain.Student;
import org.example.MyIo.repository.StudentRepository;

import javax.persistence.EntityManager;

public class StudentRepositoryImpl
        extends BaseRepositoryImpl<Student,Long>
        implements StudentRepository {


    public StudentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}