package az.ibrahimshirinov.completeJpaImpl.ManyToManyBidirectional.service;

import az.ibrahimshirinov.completeJpaImpl.ManyToManyBidirectional.model.Author;
import az.ibrahimshirinov.completeJpaImpl.ManyToManyBidirectional.model.Book;

import java.util.List;

public interface AuthorService {

    Author save(Author author);

    Author findById(Long id);

    List<Author> findAll();

    Author update(Long id, Author author);

    void delete(Long id);

    Author addBookToAuthor(Long authorId, Book book);
}
