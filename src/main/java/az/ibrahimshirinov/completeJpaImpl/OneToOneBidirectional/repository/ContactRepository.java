package az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.repository;

import az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.model.PersonContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<PersonContact,Long> {

        PersonContact findAllByPersonId(Long personId);
}
