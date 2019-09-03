package end_project.new_meetup.converters;

import end_project.new_meetup.dto.CommentaryDTO;
import end_project.new_meetup.model.CommentaryModel;
import end_project.new_meetup.service.EventService;
import end_project.new_meetup.service.UserContextService;
import end_project.new_meetup.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component

public class CommentaryConverter {

    private final EventService eventService;
    private final UserService userService;
    private UserContextService userContextService;

    public CommentaryConverter(EventService eventService, UserService userService, UserContextService userContextService) {
        this.eventService = eventService;
        this.userService = userService;
        this.userContextService = userContextService;
    }

    public CommentaryModel convertDtoToModel(CommentaryDTO commentaryDTO, Long eventId){
        final CommentaryModel commentaryModel = new CommentaryModel();
        commentaryModel.setDescription(commentaryDTO.getDescription());
        commentaryModel.setEventModel(eventService.findEventById(eventId));
        commentaryModel.setAddTime(LocalDateTime.now());
        commentaryModel.setUserModel(userService.findUserByEmail(userContextService.getLogedUserName()).orElseThrow(() -> new IllegalArgumentException()));
        return commentaryModel;
    }

    public CommentaryDTO convertModelToDTO (CommentaryModel commentaryModel){
        final CommentaryDTO commentaryDTO = new CommentaryDTO();
        commentaryDTO.setDescription(commentaryModel.getDescription());
        commentaryDTO.setAddTime(commentaryModel.getAddTime());
        return commentaryDTO;
    }
}
