package org.example.MyIo.service.impl;

import org.example.MyIo.base.service.impl.BaseServiceImpl;
import org.example.MyIo.domain.Course;
import org.example.MyIo.repository.CourseRepository;
import org.example.MyIo.service.CourseService;

public class CourseServiceImpl
        extends BaseServiceImpl<Course, Long, CourseRepository>
        implements CourseService {
    public CourseServiceImpl(CourseRepository repository) {
        super(repository);
    }
}
