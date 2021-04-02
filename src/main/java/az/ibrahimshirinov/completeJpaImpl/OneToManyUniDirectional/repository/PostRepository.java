package az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.repository;

import az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
