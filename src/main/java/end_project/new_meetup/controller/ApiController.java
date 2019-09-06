package end_project.new_meetup.controller;

import end_project.new_meetup.dto.EventDTO;
import end_project.new_meetup.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meetup/coming_events")
public class ApiController {

    @Autowired
    private final ApiService apiService;
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping()
    public List<EventDTO> getComingEvent(){
        return apiService.displayComingEventList();
    }
}
