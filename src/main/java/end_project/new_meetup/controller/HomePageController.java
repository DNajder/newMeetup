package end_project.new_meetup.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomePageController {

    @GetMapping({"/home", "home"})
    public String viewHomePage(){
        return "homePage";
    }

//    inaczej rozwiazanie
//    @GetMapping({"/home", "home"})
//    public String viewHomePage(Authentication authentication){
//        authentication.getName();
//        return "homePage";
//    }
}
