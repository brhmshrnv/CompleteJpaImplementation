package az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.service;

import az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.model.Post;

import java.util.List;

public interface PostService {

    Post save(Post post);
    Post findById(Long id);
    List<Post> findAll();
    Post update(Long id, Post post);
    void delete(Long id);
}
