package org.example.MyIo;

import org.example.MyIo.repository.CourseRatingRepository;
import org.example.MyIo.repository.CourseRepository;
import org.example.MyIo.repository.StudentRepository;
import org.example.MyIo.repository.impl.CourseRatingRepositoryImpl;
import org.example.MyIo.repository.impl.CourseRepositoryImpl;
import org.example.MyIo.repository.impl.StudentRepositoryImpl;
import org.example.MyIo.service.CourseRatingService;
import org.example.MyIo.service.CourseService;
import org.example.MyIo.service.StudentService;
import org.example.MyIo.service.impl.CourseRatingServiceImpl;
import org.example.MyIo.service.impl.CourseServiceImpl;
import org.example.MyIo.service.impl.StudentServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationContext {
    private static final EntityManagerFactory emf;
    private static final EntityManager em;
    private static final CourseRepository COURSE_REPOSITORY;
    private static final CourseService COURSE_SERVICE;
    private static final StudentRepository STUDENT_REPOSITORY;
    private static final StudentService STUDENT_SERVICE;
    private static final CourseRatingRepository COURSE_RATING_REPOSITORY;
    private static final CourseRatingService COURSE_RATING_SERVICE;

    static {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        COURSE_REPOSITORY = new CourseRepositoryImpl(em);
        COURSE_SERVICE = new CourseServiceImpl(COURSE_REPOSITORY);
        STUDENT_REPOSITORY = new StudentRepositoryImpl(em);
        STUDENT_SERVICE = new StudentServiceImpl(STUDENT_REPOSITORY);
        COURSE_RATING_REPOSITORY = new CourseRatingRepositoryImpl(em);
        COURSE_RATING_SERVICE = new CourseRatingServiceImpl(COURSE_RATING_REPOSITORY);
    }

    public static StudentService getStudentService() {
        return STUDENT_SERVICE;
    }

    public static CourseService getCourseService() {
        return COURSE_SERVICE;
    }

    public static CourseRatingService getCourseRatingService() {
        return COURSE_RATING_SERVICE;
    }
}
