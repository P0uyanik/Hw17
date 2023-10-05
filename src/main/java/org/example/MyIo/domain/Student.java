package org.example.MyIo.domain;

import org.example.MyIo.base.domain.BaseEntity;

import javax.persistence.*;

@Entity
public class Student extends BaseEntity<Long> {
    private String name;

    @OneToOne (mappedBy = "student")

    private Course courseList ;

    public Student() {
    }

    public Student(Long id) {
        super(id);
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourseList() {
        return courseList;
    }

    public void setCourseList(Course courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
