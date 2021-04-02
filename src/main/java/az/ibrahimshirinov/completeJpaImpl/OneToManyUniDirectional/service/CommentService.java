package az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.service;


import az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> save(Long postId,Comment comment);
    List<Comment> getAll(Long postId);
}
