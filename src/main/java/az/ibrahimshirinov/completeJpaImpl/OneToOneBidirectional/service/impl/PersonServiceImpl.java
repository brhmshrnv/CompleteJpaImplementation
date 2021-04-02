package az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.service.impl;

import az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.model.Person;
import az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.repository.PersonRepository;
import az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(Long id) {

        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found person with id="+id);
        }
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(Long id, Person person) {

        return personRepository.findById(id).map(personObj -> {
                personObj.setName(person.getName());
                personObj.setSurname(person.getSurname());
                return personRepository.save(personObj);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cant update person with id"+ id));
    }

    @Override
    public void delete(Long id) {

        Optional<Person> optionalPerson = personRepository.findById(id);
        optionalPerson.ifPresent(personRepository::delete);
    }
}
