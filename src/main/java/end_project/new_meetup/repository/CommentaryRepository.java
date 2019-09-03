package end_project.new_meetup.repository;

import end_project.new_meetup.model.CommentaryModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentaryRepository  extends CrudRepository<CommentaryModel, Long>, JpaRepository<CommentaryModel, Long> {


    @Query(value="select * from commentary where event_id = :parameter",nativeQuery = true)
    List<CommentaryModel> findAllByEventId(@Param("parameter") String parameter);

    @Override
    List<CommentaryModel> findAll(Sort sort);

    @Override
    List<CommentaryModel> findAll();
}
