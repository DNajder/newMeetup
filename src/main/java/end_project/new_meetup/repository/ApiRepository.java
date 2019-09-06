package end_project.new_meetup.repository;

import end_project.new_meetup.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApiRepository extends CrudRepository<EventModel, Long>, JpaRepository<EventModel, Long> {

//    @Query(value="select * from event where title LIKE :parameter",nativeQuery = true)
//    List<EventModel> findAllByTitleQuery(@Param("parameter") String parameter);
    @Query(value="select * from event where EVEN_START >NOW()",nativeQuery = true)
    List<EventModel> findAllCommingEvent();
}
