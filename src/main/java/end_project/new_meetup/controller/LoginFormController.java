package end_project.new_meetup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginFormController {
    @GetMapping ({"/login", "login"})
    public String loginForm() {
        return "loginForm";
    }
}

