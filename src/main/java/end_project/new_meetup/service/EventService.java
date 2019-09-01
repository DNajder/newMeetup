package end_project.new_meetup.service;

import end_project.new_meetup.converters.EventConverter;
import end_project.new_meetup.dto.EventDTO;
import end_project.new_meetup.model.EventModel;
import end_project.new_meetup.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final EventConverter eventConverter;

    public EventService(EventRepository eventRepository, EventConverter eventConverter) {
        this.eventRepository = eventRepository;
        this.eventConverter = eventConverter;
    }

    public EventModel saveEvent(EventModel eventModel) {
        return eventRepository.save(eventModel);
    }


    public List<EventDTO> displayEventList() {
        List<EventModel> eventModels = new ArrayList<>();
        eventRepository.findAll().forEach(e -> eventModels.add(e));


        List<EventDTO> eventDTOS = eventModels.stream()
                .map(e -> eventConverter.converModelToDto(e))
                .filter(e -> e.getEvenEnd().compareTo(LocalDate.now()) > 0)
                .sorted(Comparator.comparing(e->e.getEvenStart()))
                .collect(Collectors.toList());

        return eventDTOS;
    }
}


