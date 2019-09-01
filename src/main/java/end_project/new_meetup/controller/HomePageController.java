package end_project.new_meetup.controller;

import end_project.new_meetup.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

   private final EventService eventService;

    public HomePageController(EventService eventService) {
        this.eventService = eventService;
    }

    //    inaczej rozwiazanie
//    @GetMapping({"/home", "home"})
//    public String viewHomePage(Authentication authentication){
//        authentication.getName();
//        return "homePage";
//    }

    @GetMapping({"/home", "home"})
    public String listOfEvent(Model model) {
        model.addAttribute("eventDTOS", eventService.displayEventList());
        return "homePage";
    }
}
