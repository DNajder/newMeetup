package end_project.new_meetup.service;

import end_project.new_meetup.model.EventModel;
import end_project.new_meetup.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    public EventModel saveEvent(EventModel eventModel){
        return eventRepository.save(eventModel);
    }
}
