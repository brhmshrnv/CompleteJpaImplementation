package az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.api;


import az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.model.Course;
import az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher/")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("{teacherId}/courses")
    public List<Course> findAllCourses(@PathVariable(name = "teacherId") Long teacherId) {
          return   courseService.findByTeacherId(teacherId);
    }

    @PostMapping("{teacherId}/courses")
    public List<Course> saveCourse(@PathVariable(name = "teacherId") Long teacherId,@RequestBody Course course) {
        return courseService.save(teacherId,course);
    }

}

