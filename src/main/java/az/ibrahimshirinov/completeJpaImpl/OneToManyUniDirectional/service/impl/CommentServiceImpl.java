package az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.service.impl;

import az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.model.Comment;
import az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.model.Post;
import az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.repository.CommentRepository;
import az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.repository.PostRepository;
import az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    public final CommentRepository commentRepository;
    public final PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }


    @Override
    public List<Comment> save(Long postId, Comment comment) {

        Optional<Post> opt = postRepository.findById(postId);
        if (opt.isPresent()) {
            comment.setPost(opt.get());
            commentRepository.save(comment);

            return commentRepository.findAllByPostId(postId);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found post with id="+ postId);
        }

    }

    @Override
    public List<Comment> getAll(Long postId) {
        return commentRepository.findAllByPostId(postId);
    }
}

