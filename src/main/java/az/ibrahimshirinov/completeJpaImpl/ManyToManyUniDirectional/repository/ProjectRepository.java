package az.ibrahimshirinov.completeJpaImpl.ManyToManyUniDirectional.repository;

import az.ibrahimshirinov.completeJpaImpl.ManyToManyUniDirectional.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
