package az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "person")
    private PersonContact personContact;

}
