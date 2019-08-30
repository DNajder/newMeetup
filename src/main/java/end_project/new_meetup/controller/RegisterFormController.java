package end_project.new_meetup.controller;

import end_project.new_meetup.dao.UserModel;
import end_project.new_meetup.dto.UserRegisterDTO;
import end_project.new_meetup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
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

   private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping({"/registration", "registration"})
    public String showUserRegisterForm(Model model) {
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        model.addAttribute("userRegisterDTO", userRegisterDTO);
        return "registerForm";
    }
    @PostMapping({"/registration", "registration"})
    public String UserRegisterDtoExtender(@ModelAttribute @Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()){
            return "registration";
        }

        UserModel userModel= new UserModel();
        userModel.setName(userRegisterDTO.getName());
        userModel.setEmail(userRegisterDTO.getEmail());
        userModel.setPasswordHash(passwordEncoder.encode(userRegisterDTO.getPassword()));
           return "redirect:/registrationSuccess";
    }
}
