package end_project.new_meetup.controller;

import org.springframework.stereotype.Controller;

@Controller
public class StartPageController {
    public String startPage() {
        return "startPage";
    }
}
