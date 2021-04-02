package az.ibrahimshirinov.completeJpaImpl.OneToOneUniDirectional.api;

import az.ibrahimshirinov.completeJpaImpl.OneToOneUniDirectional.model.Instructor;
import az.ibrahimshirinov.completeJpaImpl.OneToOneUniDirectional.service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor/")
public class InstructorController {

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    private final InstructorService instructorService;

    @PostMapping
    public Instructor save(@RequestBody Instructor instructor) {
        return instructorService.save(instructor);
    }

    @GetMapping("{id}")
    public Instructor getOne(@PathVariable(name = "id") Long id) {
        return instructorService.findById(id);
    }

    @GetMapping
    public List<Instructor> getAll() {
        return instructorService.findAll();
    }

    @PutMapping("{id}")
    public Instructor update(@PathVariable(name = "id") Long id,@RequestBody Instructor instructor){

        return instructorService.update(id,instructor);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        instructorService.delete(id);
    }

}
