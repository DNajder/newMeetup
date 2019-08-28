package end_project.new_meetup.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", unique = true)
    String name;

    @Column(name = "emial", unique = true)
    String email;

    @Column(name = "password_hash")
    String passwordHash;

    @ManyToMany
    private Set<RoleModel> roles;

}
