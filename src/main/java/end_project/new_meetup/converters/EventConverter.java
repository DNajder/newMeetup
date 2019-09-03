package end_project.new_meetup.converters;

import end_project.new_meetup.dto.EventDTO;
import end_project.new_meetup.model.EventModel;
import end_project.new_meetup.service.UserContextService;
import end_project.new_meetup.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class EventConverter {

    private final UserService userService;
    private UserContextService userContextService;

    public EventConverter(UserService userService, UserContextService userContextService) {
        this.userService = userService;
        this.userContextService = userContextService;
    }

    public EventModel convertDtoToModel(EventDTO eventDTO){
        final EventModel eventModel = new EventModel();
        eventModel.setTitle(eventDTO.getTitle());
        eventModel.setEvenStart(eventDTO.getEvenStart());
        eventModel.setEvenEnd(eventDTO.getEvenEnd());
        eventModel.setDescription(eventDTO.getDescription());
        eventModel.setCreator(userService.findUserByEmail(userContextService.getLogedUserName()).orElseThrow(() -> new IllegalArgumentException()));
        return eventModel;
    }
    public EventDTO convertModelToDto(EventModel eventModel){
        final EventDTO eventDTO= new EventDTO();
        eventDTO.setId(eventModel.getId());
        eventDTO.setTitle(eventModel.getTitle());
        eventDTO.setEvenStart(eventModel.getEvenStart());
        eventDTO.setEvenEnd(eventModel.getEvenEnd());
        eventDTO.setDescription(eventModel.getDescription());
        return eventDTO;
    }
}
