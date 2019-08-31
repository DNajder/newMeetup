package end_project.new_meetup.controller;

import end_project.new_meetup.dto.UserRegisterDTO;
import end_project.new_meetup.converters.UserRegisterToUserModelConverter;
import end_project.new_meetup.service.UserService;
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
public class RegisterFormController {

    private final UserService userService;
    private final UserRegisterToUserModelConverter userRegisterToUserModelConverter;

    @GetMapping({"/registration", "registration"})
    public String showUserRegisterForm(Model model) {
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        model.addAttribute("userRegisterDTO", userRegisterDTO);
        return "registerForm";
    }

    @PostMapping({"/registration", "registration"})
    public String UserRegisterDtoExtender(@ModelAttribute @Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult, Model model) {

        System.out.println(userRegisterDTO);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.saveUser(userRegisterToUserModelConverter.convert(userRegisterDTO));

        return "redirect:/registrationSuccess";
    }
}
