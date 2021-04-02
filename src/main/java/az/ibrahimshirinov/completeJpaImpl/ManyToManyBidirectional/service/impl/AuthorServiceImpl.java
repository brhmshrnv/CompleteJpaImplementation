package az.ibrahimshirinov.completeJpaImpl.ManyToManyBidirectional.service.impl;

import az.ibrahimshirinov.completeJpaImpl.ManyToManyBidirectional.model.Author;
import az.ibrahimshirinov.completeJpaImpl.ManyToManyBidirectional.model.Book;
import az.ibrahimshirinov.completeJpaImpl.ManyToManyBidirectional.repository.AuthorRepository;
import az.ibrahimshirinov.completeJpaImpl.ManyToManyBidirectional.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findById(Long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()){
            return optionalAuthor.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Cant find author with id="+id);
        }
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author update(Long id, Author author) {

        Optional<Author> opt = authorRepository.findById(id);
        if (opt.isPresent()) {
          return   authorRepository.save(author);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cant update author with id="+id);
        }
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author addBookToAuthor(Long authorId, Book book) {
        Optional<Author> opt = authorRepository.findById(authorId);
        if (opt.isPresent()) {
            //opt.get().setBooks();
        }
        return null;
    }


}
