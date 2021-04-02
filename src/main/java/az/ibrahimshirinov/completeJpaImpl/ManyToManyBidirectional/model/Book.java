package az.ibrahimshirinov.completeJpaImpl.ManyToManyBidirectional.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String desc;

    @ManyToMany
    @JoinTable(name = "Book_Authors",
               joinColumns = @JoinColumn(name = "author_id"),
               inverseJoinColumns = @JoinColumn(name = "book_id"))
    List<Author> authors;


}
