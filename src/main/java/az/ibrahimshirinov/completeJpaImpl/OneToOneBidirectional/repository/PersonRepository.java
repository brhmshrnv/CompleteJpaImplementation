package az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.repository;

import az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

}
