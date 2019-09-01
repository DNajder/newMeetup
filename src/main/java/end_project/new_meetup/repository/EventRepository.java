package end_project.new_meetup.repository;

import end_project.new_meetup.model.EventModel;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<EventModel, Long> {
}
