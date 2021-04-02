package az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.api;

import az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.model.Post;
import az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post/")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> findAllPosts(){
        return postService.findAll();
    }

    @GetMapping("{id}")
    public Post findPostById(@PathVariable(name = "id") Long id) {
        return postService.findById(id);
    }

    @PostMapping
    public Post savePost(@RequestBody Post post){

        return postService.save(post);
    }

    @PutMapping("{id}")
    public Post updatePost(@PathVariable(name = "id") Long id, @RequestBody Post post) {

        return postService.update(id,post);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deletePost(@PathVariable(name = "id") Long id) {
        postService.delete(id);
    }
}
