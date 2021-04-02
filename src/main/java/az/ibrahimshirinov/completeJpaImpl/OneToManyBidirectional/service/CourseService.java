package az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.service;

import az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> findByTeacherId(Long teacherId);
    List<Course> save(Long teacherId,Course course);
}
