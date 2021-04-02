package az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.api;


import az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.model.PersonContact;
import az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.service.ContactService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person/")
public class ContactController {

    private final ContactService contactService;

    public ContactController( ContactService contactService) {
        this.contactService = contactService;
    }


    @PostMapping("/{personId}/contacts")
    public PersonContact createContact(@PathVariable(name = "personId") Long personId, @RequestBody PersonContact personContact) {

        return contactService.createContact(personId,personContact);
    }

    @GetMapping("/{personId}/contacts")
    public PersonContact getContact(@PathVariable(name = "personId") Long personId){
        return contactService.getContactByPersonId(personId);
    }
}
