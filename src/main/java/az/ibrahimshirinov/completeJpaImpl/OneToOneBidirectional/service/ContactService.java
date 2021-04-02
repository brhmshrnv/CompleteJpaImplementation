package az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.service;

import az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.model.PersonContact;

public interface ContactService {
    PersonContact createContact(Long personId, PersonContact personContact);
    PersonContact getContactByPersonId(Long personId);
}
