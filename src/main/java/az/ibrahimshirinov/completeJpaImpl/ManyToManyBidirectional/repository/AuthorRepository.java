package az.ibrahimshirinov.completeJpaImpl.ManyToManyBidirectional.repository;

import az.ibrahimshirinov.completeJpaImpl.ManyToManyBidirectional.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
