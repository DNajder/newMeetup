package end_project.new_meetup.controller;

import end_project.new_meetup.dto.EventDTO;
import end_project.new_meetup.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomePageController {

   private final EventService eventService;
    public static List<EventDTO> listOfHomeEvents;

    public HomePageController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping({"/home", "home"})
    public String listOfEvent(Model model) {

        listOfHomeEvents = eventService.displayActiveEventList();

        model.addAttribute("eventActiveDTOS", listOfHomeEvents);
        System.out.println(listOfHomeEvents.toString());
        return "homePage";
    }
}

//    inaczej rozwiazanie pobierania kontextu użytkownika u mnie wyniesione do osobnej klasy userContext
//    @GetMapping({"/home", "home"})
//    public String viewHomePage(Authentication authentication){
//        authentication.getName();
//        return "homePage";
//    }@Query(value="select * from event where title LIKE :parameter",nativeQuery = true)
//    List<EventModel> findAllByTitleQuery(@Param("parameter") String parameter);
