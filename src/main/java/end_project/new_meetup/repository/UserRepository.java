package end_project.new_meetup.repository;

import end_project.new_meetup.model.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserModel, Long> {

    Optional<UserModel> findUserByEmail(String email);
}
