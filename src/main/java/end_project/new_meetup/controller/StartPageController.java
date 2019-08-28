package end_project.new_meetup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartPageController {

    @GetMapping({"", "/"})
    public String startPage() {
        return "startPage";
    }
}
