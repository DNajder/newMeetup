package end_project.new_meetup.mapper;

import end_project.new_meetup.model.RoleName;
import end_project.new_meetup.model.UserModel;
import end_project.new_meetup.dto.UserRegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@Getter
@Component
@RequiredArgsConstructor
public class UserRegisterToUserModelMapper{

    private final PasswordEncoder passwordEncoder;

    public UserModel convert(UserRegisterDTO userRegisterDto) {

        final UserModel userModel = new UserModel();
        userModel.setName(userRegisterDto.getName());
        userModel.setEmail(userRegisterDto.getEmail());
        userModel.setPasswordHash(passwordEncoder.encode(userRegisterDto.getPassword()));
        return userModel;
    }
}
