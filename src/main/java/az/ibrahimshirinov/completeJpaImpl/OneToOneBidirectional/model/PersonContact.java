package az.ibrahimshirinov.completeJpaImpl.OneToOneBidirectional.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class PersonContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "facebook")
    private String facebook;
    @Column(name = "twitter")
    private String twitter;
    @Column(name = "linkedin")
    private String linkedin;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id" ,referencedColumnName = "id")
    private Person person;
}
