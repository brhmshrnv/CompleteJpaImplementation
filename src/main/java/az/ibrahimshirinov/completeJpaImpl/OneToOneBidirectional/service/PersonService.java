package az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.service;

import az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    Person findById(Long id);
    Person save(Person person);
    Person update(Long id, Person person);
    void delete(Long id);
}
