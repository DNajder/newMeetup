package end_project.new_meetup.model;

import end_project.new_meetup.service.RoleService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;

import javax.persistence.*;
import java.util.HashSet;
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

    @ManyToMany
    private Set<RoleModel> roles =new HashSet<>();

    @ManyToMany
    private Set<EventModel> events = new HashSet<>();

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private Set<EventModel> myEvents = new HashSet<>();

    @OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL)
    private Set<CommentaryModel> commentary = new HashSet<>();

    public void addRole(RoleModel roleModel) {
        roles.add(roleModel);
    }
    public UserModel addEvent(UserModel userModel,EventModel eventModel){
        userModel.events.add(eventModel);
        return userModel;
    }

}
