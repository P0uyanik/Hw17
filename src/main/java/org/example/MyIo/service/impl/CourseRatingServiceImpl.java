package org.example.MyIo.service.impl;

import org.example.MyIo.base.service.impl.BaseServiceImpl;
import org.example.MyIo.domain.CourseRating;
import org.example.MyIo.repository.CourseRatingRepository;
import org.example.MyIo.service.CourseRatingService;

public class CourseRatingServiceImpl
        extends BaseServiceImpl<CourseRating, Long, CourseRatingRepository>
        implements CourseRatingService {
    public CourseRatingServiceImpl(CourseRatingRepository repository) {
        super(repository);
    }
}
