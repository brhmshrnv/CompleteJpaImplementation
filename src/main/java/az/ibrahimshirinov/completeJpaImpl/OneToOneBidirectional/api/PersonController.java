package az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.api;


import az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.model.Person;
import az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person/")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons(){
        return personService.findAll();
    }

    @GetMapping("{id}")
    public Person getPersonById(@PathVariable(name = "id") Long id) {
        return personService.findById(id);
    }

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping("{id}")
    public Person updatePerson(@PathVariable(name = "id") Long id, @RequestBody Person person) {
        return personService.update(id,person);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable(name = "id") Long id) {
        personService.delete(id);
    }
}
