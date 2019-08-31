package end_project.new_meetup.controller;

import end_project.new_meetup.dto.EventDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EventFormController {
    @GetMapping({"/event", "event"})
    public String showEventForm(Model model){
        EventDTO eventDTO = new EventDTO();
        model.addAttribute("eventDTO", eventDTO);
        return "eventForm";
    }
    @PostMapping({"/event", "event"})
    public String UserRegisterDtoExtender(@ModelAttribute @Valid EventDTO eventDTO , BindingResult bindingResult, Model model) {

        System.out.println(eventDTO);
        if (bindingResult.hasErrors()) {
            return "event";
        }
//        userService.saveUser(userRegisterToUserModelConverter.convert(userRegisterDTO));

        return "redirect:/registrationSuccess";
    }
}
