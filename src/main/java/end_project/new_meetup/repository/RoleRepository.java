package end_project.new_meetup.repository;

import end_project.new_meetup.model.RoleModel;
import end_project.new_meetup.model.RoleName;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends CrudRepository<RoleModel, Long> {

    List<RoleModel> findAllByRoleName(RoleName roleName);

    Optional<RoleModel> findByRoleName(RoleName roleName);

}
