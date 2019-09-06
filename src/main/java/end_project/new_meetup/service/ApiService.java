package end_project.new_meetup.service;

import end_project.new_meetup.converters.EventConverter;
import end_project.new_meetup.dto.EventDTO;
import end_project.new_meetup.model.EventModel;
import end_project.new_meetup.repository.ApiRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiService {

    private final ApiRepository apiRepository;
    private final EventConverter eventConverter;

    public ApiService(ApiRepository apiRepository, EventConverter eventConverter) {
        this.apiRepository = apiRepository;
        this.eventConverter = eventConverter;
    }

    public List<EventDTO> displayComingEventList() {
        List<EventModel> eventModels = new ArrayList<>(apiRepository.findAllCommingEvent());

        return eventModels.stream()
                .map(eventConverter::convertModelApiDto)
                .filter(e -> e.getEvenEnd().compareTo(LocalDate.now()) > 0)
                .sorted(Comparator.comparing(EventDTO::getEvenStart))
                .collect(Collectors.toList());
    }
}
