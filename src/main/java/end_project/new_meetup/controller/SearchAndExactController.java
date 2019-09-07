package end_project.new_meetup.controller;

import end_project.new_meetup.converters.CommentaryConverter;
import end_project.new_meetup.dto.CommentaryDTO;
import end_project.new_meetup.dto.EventDTO;
import end_project.new_meetup.dto.UserDTO;
import end_project.new_meetup.model.EventModel;
import end_project.new_meetup.model.UserModel;
import end_project.new_meetup.service.CommentaryService;
import end_project.new_meetup.service.EventService;
import end_project.new_meetup.service.UserContextService;
import end_project.new_meetup.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SearchAndExactController {

    private final EventService eventService;
    private static List<EventDTO> listOfFoundEvents;
    private List<CommentaryDTO> commentList;
    private List<UserDTO> joinUserList;
    private final CommentaryService commentaryService;
    private final CommentaryConverter commentaryConverter;
    private final UserContextService userContextService;
    private final UserService userService;
    private EventDTO exactEvent;


    @GetMapping({"/search", "search"})
    public String displaySearchResult(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        String parameter = request.getParameter("title");
        parameter = "%" + parameter + "%";

        log.info(parameter);
        listOfFoundEvents = eventService.displaySearchEventList(parameter);

        model.addAttribute("eventSearchDTOS", listOfFoundEvents);
        return "searchEffectPage";
    }

    @GetMapping({"/exact", "exact"})
    public String exactPageView(HttpServletRequest request, HttpServletResponse response, Model exactModel, Model commentModel, Model comModel, Model joinUserModel, Model switchModel) {
        int idParam = Integer.parseInt(request.getParameter("id"));
        if (request.getParameter("hp").equals("true")) {
            exactEvent = HomePageController.listOfHomeEvents.get(idParam);
        } else {
            exactEvent = listOfFoundEvents.get(idParam);
        }
        log.info(String.valueOf(idParam));
        String eventId = request.getParameter("eid");
        log.info(eventId);

        UserModel findMember = userService.findUserByEmail(userContextService.getLogedUserName()).orElseThrow(IllegalArgumentException::new);
        commentList = commentaryService.displayAllCommentBiEventId(eventId);
        joinUserList = userService.dispalyUserByEventId(eventId);

        Optional<UserDTO> EmailList = joinUserList.stream()
                .filter(e -> e.getEmail().equals(findMember.getEmail()))
                .findAny();

        boolean switchButton = (EmailList.isPresent());

        System.out.println(joinUserList.toString());

        switchModel.addAttribute("switchButton", switchButton);
        joinUserModel.addAttribute("joinUser", joinUserList);
        exactModel.addAttribute("exactEvent", exactEvent);
        commentModel.addAttribute("commentList", commentList);
        System.out.println(exactEvent.toString());

        CommentaryDTO commentaryDTO = new CommentaryDTO();
        comModel.addAttribute("commentaryDTO", commentaryDTO);

        return "exactEventView";
    }

    @PostMapping({"/comment", "comment"})
    public String commentaryAdding(@ModelAttribute @Valid CommentaryDTO commentaryDTO, BindingResult bindingResult, HttpServletRequest request, Model exactModel, Model commentModel, Model joinUserModel, Model switchModel) {

        System.out.println(commentaryDTO);
        if (bindingResult.hasErrors()) {
            return "exactEventView";
        }
        Long eventId = Long.parseLong(request.getParameter("eid"));
        commentaryService.saveComment(commentaryConverter.convertDtoToModel(commentaryDTO, eventId));

        UserModel findMember = userService.findUserByEmail(userContextService.getLogedUserName()).orElseThrow(IllegalArgumentException::new);

        commentList = commentaryService.displayAllCommentBiEventId(request.getParameter("eid"));

        Optional<UserDTO> EmailList = joinUserList.stream()
                .filter(e -> e.getEmail().equals(findMember.getEmail()))
                .findAny();

        boolean switchButton = (EmailList.isPresent());

        switchModel.addAttribute("switchButton", switchButton);
        exactModel.addAttribute("exactEvent", exactEvent);
        commentModel.addAttribute("commentList", commentList);
        joinUserModel.addAttribute("joinUser", joinUserList);
        return "exactEventView";
    }

    @PostMapping({"/join", "join"})
    public String memberManager(@ModelAttribute @Valid CommentaryDTO commentaryDTO, BindingResult bindingResult, HttpServletRequest request, Model exactModel, Model commentModel, Model joinUserModel,Model switchModel) {

        String eventId = request.getParameter("eid");

        UserModel findMember = userService.findUserByEmail(userContextService.getLogedUserName()).orElseThrow(IllegalArgumentException::new);

        EventModel eventById = eventService.findEventById(Long.parseLong(eventId));

        System.out.println(findMember.toString());
        System.out.println(eventById.toString());
        userService.saveUser(findMember.addEvent(findMember, eventById));

        joinUserList = userService.dispalyUserByEventId(eventId);

        commentList = commentaryService.displayAllCommentBiEventId(request.getParameter("eid"));

        Optional<UserDTO> EmailList = joinUserList.stream()
                .filter(e -> e.getEmail().equals(findMember.getEmail()))
                .findAny();

        boolean switchButton = (EmailList.isPresent());

        switchModel.addAttribute("switchButton", switchButton);
        joinUserModel.addAttribute("joinUser", joinUserList);
        exactModel.addAttribute("exactEvent", exactEvent);
        commentModel.addAttribute("commentList", commentList);

        return "exactEventView";
    }

    @PostMapping({"/leave", "leave"})
    public String deleteManager(@ModelAttribute @Valid CommentaryDTO commentaryDTO, BindingResult bindingResult, HttpServletRequest request, Model exactModel, Model commentModel, Model joinUserModel, Model switchModel) {

        String eventId = request.getParameter("eid");

        UserModel findMember = userService.findUserByEmail(userContextService.getLogedUserName()).orElseThrow(IllegalArgumentException::new);

        EventModel eventById = eventService.findEventById(Long.parseLong(eventId));

        System.out.println(findMember.toString());
        System.out.println(eventById.toString());
        userService.saveUser(findMember.removeEvent(findMember, eventById));


        joinUserList = userService.dispalyUserByEventId(eventId);
        Optional<UserDTO> EmailList = joinUserList.stream()
                .filter(e -> e.getEmail().equals(findMember.getEmail()))
                .findAny();

        boolean switchButton = (EmailList.isPresent());
        System.out.println(switchButton);

        switchModel.addAttribute("switchButton", switchButton);
        joinUserModel.addAttribute("joinUser", joinUserList);
        exactModel.addAttribute("exactEvent", exactEvent);
        commentModel.addAttribute("commentList", commentList);

        return "exactEventView";
    }


}

//
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