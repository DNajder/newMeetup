package end_project.new_meetup.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "commentary")
public class CommentaryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentary_id")
    private Long id;

    @Lob
    @Column(name = "context")
    private String description;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventModel eventModel;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel userModel;

}