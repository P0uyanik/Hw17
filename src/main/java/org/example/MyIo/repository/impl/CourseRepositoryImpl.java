package org.example.MyIo.repository.impl;

import org.example.MyIo.base.repository.impl.BaseRepositoryImpl;
import org.example.MyIo.domain.Course;
import org.example.MyIo.repository.CourseRepository;

import javax.persistence.EntityManager;

public class CourseRepositoryImpl
        extends BaseRepositoryImpl<Course,Long>
        implements CourseRepository {
    public CourseRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }
}
