package end_project.new_meetup.service;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserContextService {

    public String getLogedUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();{
            if (authentication instanceof AnonymousAuthenticationToken){
                return null;
            }
            System.out.println(authentication.getName());
            return authentication.getName();
        }
    }
}
