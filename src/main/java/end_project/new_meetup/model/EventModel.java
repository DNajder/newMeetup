package end_project.new_meetup.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "event")
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel creator;

    @Column(name = "even_start")
    private LocalDate evenStart;

    @Column(name = "even_end")
    private LocalDate evenEnd;

    @Lob
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "eventModel", cascade = CascadeType.ALL)
    private Set<CommentaryModel> commentary;

}
