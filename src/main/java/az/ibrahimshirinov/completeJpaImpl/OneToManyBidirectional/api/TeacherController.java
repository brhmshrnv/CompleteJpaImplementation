package az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.api;

import az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.model.Teacher;
import az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher/")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @PostMapping
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    @GetMapping("{id}")
    public Teacher findTeacherById(@PathVariable(name = "id") Long id){

        return teacherService.findById(id);
    }

    @GetMapping
    public List<Teacher> findAllTeachers() {
        return teacherService.findAll();
    }

    @PutMapping("{id}")
    public Teacher updateTeacher(@PathVariable(name = "id") Long id, @RequestBody Teacher teacher) {
        return teacherService.update(id,teacher);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteTeacher(@PathVariable(name = "id") Long id) {
        teacherService.delete(id);
    }

}

