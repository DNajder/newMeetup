package end_project.new_meetup.controller;

import end_project.new_meetup.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SearchPageController {

    private final EventService eventService;

    public SearchPageController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping({"/search", "search"})
    public String displaySearchResult(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        String parameter = request.getParameter("title");
        parameter = "%" + parameter + "%";
        System.out.println(parameter);

        model.addAttribute("eventSearchDTOS", eventService.displaySearchEventList(parameter));
        return "searchPage";
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