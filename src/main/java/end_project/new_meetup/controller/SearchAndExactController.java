package end_project.new_meetup.controller;

import end_project.new_meetup.converters.CommentaryConverter;
import end_project.new_meetup.dto.CommentaryDTO;
import end_project.new_meetup.dto.EventDTO;
import end_project.new_meetup.service.CommentaryService;
import end_project.new_meetup.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class SearchAndExactController {

    private final EventService eventService;
    private static List<EventDTO> listOfFoundEvents;
    private List<CommentaryDTO> commentList;
    private final CommentaryService commentaryService;
    private final CommentaryConverter commentaryConverter;
    private EventDTO exactEvent;


    @GetMapping({"/search", "search"})
    public String displaySearchResult(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        String parameter = request.getParameter("title");
        parameter = "%" + parameter + "%";

        System.out.println(parameter);
        listOfFoundEvents = eventService.displaySearchEventList(parameter);

        model.addAttribute("eventSearchDTOS", listOfFoundEvents);
        return "searchEffectPage";
    }

    @GetMapping({"/exact", "exact"})
    public String exactPageView(HttpServletRequest request, HttpServletResponse response, Model exactModel,Model commentModel, Model comModel) {
        int idParam = Integer.parseInt(request.getParameter("id"));
        if (request.getParameter("hp").equals("true")) {
            exactEvent = HomePageController.listOfHomeEvents.get(idParam);
        } else {
            exactEvent = listOfFoundEvents.get(idParam);
        }
        System.out.println(idParam);
        commentList = commentaryService.displayAllCommentBiEventId(request.getParameter("eid"));
        exactModel.addAttribute("exactEvent", exactEvent);
        commentModel.addAttribute("commentList", commentList);
        System.out.println(exactEvent.toString());

        CommentaryDTO commentaryDTO = new CommentaryDTO();
        comModel.addAttribute("commentaryDTO", commentaryDTO);

        return "exactEventView";
    }

    @PostMapping({"/comment", "comment"})
    public String commentaryAdding (@ModelAttribute @Valid CommentaryDTO commentaryDTO, BindingResult bindingResult, HttpServletRequest request,Model exactModel, Model commentModel) {

        System.out.println(commentaryDTO);
        if (bindingResult.hasErrors()) {
            return "exactEventView";
        }
        Long eventId = Long.parseLong(request.getParameter("eid"));
        commentaryService.saveComment(commentaryConverter.convertDtoToModel(commentaryDTO, eventId));

        commentList = commentaryService.displayAllCommentBiEventId(request.getParameter("eid"));

        exactModel.addAttribute("exactEvent", exactEvent);
        commentModel.addAttribute("commentList", commentList);

        return "exactEventView";
    }





}







//try (Stream<User> stream = repository.findAllByCustomQueryAndStream()) {
//        stream.forEach(…);

//@Controller
//@RequestMapping("/users")
//class UserController {
//
//    @RequestMapping("/{id}")
//    String showUserForm(@PathVariable("id") User user, Model model) {
//
//        model.addAttribute("user", user);
//        return "userForm";
//    }
//}