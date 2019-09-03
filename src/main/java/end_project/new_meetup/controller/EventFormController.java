package end_project.new_meetup.controller;

import end_project.new_meetup.converters.EventConverter;
import end_project.new_meetup.dto.EventDTO;
import end_project.new_meetup.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class EventFormController {

    private final EventService eventService;
    private final EventConverter eventConverter;

    @GetMapping({"/event", "event"})
    public String showEventForm(Model model) {
        EventDTO eventDTO = new EventDTO();
        model.addAttribute("eventDTO", eventDTO);
        return "eventForm";
    }

    @PostMapping({"/event", "event"})
    public String EventDtoExtender(@ModelAttribute @Valid EventDTO eventDTO, BindingResult bindingResult, Model model) {

        System.out.println(eventDTO);
        if (bindingResult.hasErrors()) {
            return "eventForm";
        }
        eventService.saveEvent(eventConverter.convertDtoToModel(eventDTO));

        return "redirect:/home";
    }
}
