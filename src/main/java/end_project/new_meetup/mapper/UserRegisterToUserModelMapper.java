package end_project.new_meetup.mapper;

import end_project.new_meetup.model.UserModel;
import end_project.new_meetup.dto.UserRegisterDTO;
import end_project.new_meetup.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@Getter
@Component
@RequiredArgsConstructor
public class UserRegisterToUserModelMapper {

    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public UserModel convert(UserRegisterDTO userRegisterDto) {

        final UserModel userModel = new UserModel();
        userModel.setName(userRegisterDto.getName());
        userModel.setEmail(userRegisterDto.getEmail());
        userModel.setPasswordHash(passwordEncoder.encode(userRegisterDto.getPassword()));
        userModel.addRole(roleService.createDefaultRoles());
        return userModel;
    }
}
