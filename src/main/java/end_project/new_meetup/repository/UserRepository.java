package end_project.new_meetup.repository;

import end_project.new_meetup.dao.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long> {
}
