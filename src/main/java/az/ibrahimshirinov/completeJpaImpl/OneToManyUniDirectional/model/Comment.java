package az.ibrahimshirinov.completeJpaImpl.OneToManyUniDirectional.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @CreationTimestamp
    @Column(name = "add_date",updatable = false)
    private LocalDateTime addDate;

    @UpdateTimestamp
    @Column(name = "update_date",insertable = false)
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
