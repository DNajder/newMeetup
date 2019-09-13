package end_project.new_meetup.controller;

import end_project.new_meetup.dto.EventDTO;
import end_project.new_meetup.service.EventService;
import end_project.new_meetup.service.UserContextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Slf4j
@Controller
public class HomePageController {

   private final EventService eventService;
   private final UserContextService userContextService;
    public static List<EventDTO> listOfHomeEvents;

    public HomePageController(EventService eventService, UserContextService userContextService) {
        this.eventService = eventService;
        this.userContextService = userContextService;
    }

    @GetMapping({"/", "/home", "home"})
    public String listOfEvent(Model model, Model userE) {

        String userEmail = userContextService.getLogedUserName();
        listOfHomeEvents = eventService.displayActiveEventList();

        userE.addAttribute("userEmail", userEmail);
        model.addAttribute("eventActiveDTOS", listOfHomeEvents);
        log.info(listOfHomeEvents.toString());
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
