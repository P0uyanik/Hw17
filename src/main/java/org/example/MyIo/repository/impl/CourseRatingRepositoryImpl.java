package org.example.MyIo.repository.impl;

import org.example.MyIo.base.repository.impl.BaseRepositoryImpl;
import org.example.MyIo.domain.CourseRating;
import org.example.MyIo.repository.CourseRatingRepository;

import javax.persistence.EntityManager;

public class CourseRatingRepositoryImpl
        extends BaseRepositoryImpl<CourseRating,Long>
        implements CourseRatingRepository {
    public CourseRatingRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<CourseRating> getEntityClass() {
        return CourseRating.class;
    }
}
