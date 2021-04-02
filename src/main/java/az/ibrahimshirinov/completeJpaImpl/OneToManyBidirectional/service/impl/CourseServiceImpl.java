package az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.service.impl;

import az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.model.Course;
import az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.repository.CourseRepository;
import az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.repository.TeacherRepository;
import az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {


    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public CourseServiceImpl(CourseRepository courseRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Course> findByTeacherId(Long teacherId) {
        return courseRepository.findCoursesByCourseTeacherId(teacherId);
    }

    @Override
    public List<Course> save(Long teacherId,Course course) {

        if (teacherRepository.existsById(teacherId)) {

            teacherRepository.findById(teacherId).map(teacher -> {
                    course.setCourseTeacher(teacher);
                    courseRepository.save(course);
                    return teacher;
            });
                return courseRepository.findCoursesByCourseTeacherId(teacherId);

        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found with id = " + teacherId);


    }
}
