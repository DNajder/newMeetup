package end_project.new_meetup.repository;

import end_project.new_meetup.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserModel, Long>, JpaRepository<UserModel, Long> {

    Optional<UserModel> findUserByEmail(String email);

    @Query(value="SELECT * FROM USER JOIN USER_EVENTS ON USER_ID = USER_MODEL_USER_ID WHERE EVENTS_EVENT_ID = :parameter",nativeQuery = true)
    List<UserModel> findAllByEventId(@Param("parameter") String parameter);


//    @Query(value="SELECT USER_ID, EMAIL, NAME FROM USER JOIN USER_EVENTS ON USER_ID = USER_MODEL_USER_ID WHERE EVENTS_EVENT_ID = :parameter",nativeQuery = true)
//    List<UserModel> findAllByEventId(@Param("parameter") String parameter);

}
