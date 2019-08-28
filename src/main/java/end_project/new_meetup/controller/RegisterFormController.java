package end_project.new_meetup.controller;

import end_project.new_meetup.dto.UserRegisterDTO;
import end_project.new_meetup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class RegisterFormController {

   private final UserRepository userRepository;

    @GetMapping({"/registration", "registration"})
    public String showUserRegisterForm(Model model) {
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        model.addAttribute("userRegisterDTO", userRegisterDTO);
        return "registerForm";
    }

}
