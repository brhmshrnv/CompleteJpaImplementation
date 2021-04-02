package az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @CreationTimestamp
    @Column(name = "add_date", updatable = false )
    private LocalDateTime addDate;

    @UpdateTimestamp
    @Column(name = "update_date", insertable = false)
    private LocalDateTime updateDate;



}
