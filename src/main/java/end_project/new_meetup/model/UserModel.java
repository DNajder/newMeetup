package end_project.new_meetup.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Long id;

    @Column(name = "name", unique = true)
    String name;

    @Column(name = "email", unique = true)
    String email;

    @Column(name = "password_hash")
    String passwordHash;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<RoleModel> roles;

    @OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL )
    private Set<EventModel> events;

    @OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL)
    private Set<CommentaryModel> commentary;

}