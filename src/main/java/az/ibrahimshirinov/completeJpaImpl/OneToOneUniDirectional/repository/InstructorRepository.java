package az.ibrahimshirinov.completeJpaImpl.OneToOneUniDirectional.repository;

import az.ibrahimshirinov.completeJpaImpl.OneToOneUniDirectional.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long> {
}
