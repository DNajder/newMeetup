package end_project.new_meetup.controller;

import end_project.new_meetup.dto.CommentaryDTO;
import end_project.new_meetup.dto.EventDTO;
import end_project.new_meetup.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class SearchPageController {

    private final EventService eventService;
    public static List<EventDTO> listOfFoundEvents;

    public SearchPageController(EventService eventService) {
        this.eventService = eventService;
    }

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
    public String exactPageView(HttpServletRequest request, HttpServletResponse response, Model exactModel, Model comModel) throws ServletException, IOException {
        List<EventDTO> listOfExactEvent;
        if (request.getParameter("hp").equals("true")) {
            listOfExactEvent = HomePageController.listOfHomeEvents;
        } else {
            listOfExactEvent = listOfFoundEvents;
        }
        int idParam = Integer.parseInt(request.getParameter("id"));
        System.out.println(idParam);
        exactModel.addAttribute("exactEvent", listOfExactEvent.get(idParam));
        System.out.println(listOfExactEvent.get(idParam).toString());

        CommentaryDTO commentaryDTO = new CommentaryDTO();
        exactModel.addAttribute("commentaryDTO", commentaryDTO);

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