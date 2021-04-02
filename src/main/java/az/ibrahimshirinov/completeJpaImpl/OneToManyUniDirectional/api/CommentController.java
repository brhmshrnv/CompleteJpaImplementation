package az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.api;


import az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.model.Comment;
import az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post/")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("{postId}/comments")
    public List<Comment> findAllComments(@PathVariable(name = "id") Long postId) {
        return  commentService.getAll(postId);
    }

    @PostMapping("{postId}/comments")
    public List<Comment> saveComment(@PathVariable(name = "postId") Long postId,@RequestBody Comment comment) {
        return commentService.save(postId,comment);
    }
}

