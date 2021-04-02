package az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.service.impl;

import az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.model.Person;
import az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.model.PersonContact;
import az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.repository.ContactRepository;
import az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.repository.PersonRepository;
import az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final PersonRepository personRepository;

    @Override
    public PersonContact createContact(Long personId, PersonContact personContact) {

        Optional<Person> person = personRepository.findById(personId);

        if (person.isPresent()){
            Person personDb = person.get();
            System.out.println("=======================");
            personContact.setPerson(personDb);
            System.out.println(personContact.getPerson());
            return contactRepository.save(personContact);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id = " + personId);

        }

    }

    @Override
    public PersonContact getContactByPersonId(Long personId) {

        if (personRepository.existsById(personId)) {
                return contactRepository.findAllByPersonId(personId);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id = " + personId);
        }

    }
}
