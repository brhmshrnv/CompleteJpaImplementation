package az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.service.impl;

import az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.model.Post;
import az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.repository.PostRepository;
import az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post findById(Long id) {

        Optional<Post> optional = postRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found post with id=" + id);
        }
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post update(Long id, Post post) {

        Optional<Post> optional = postRepository.findById(id);

        if (optional.isPresent())  {
             return postRepository.save(post);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cant update post with id="+id);
        }
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
