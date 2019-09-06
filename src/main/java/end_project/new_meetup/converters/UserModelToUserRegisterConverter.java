package end_project.new_meetup.converters;

import end_project.new_meetup.dto.UserDTO;
import end_project.new_meetup.dto.UserRegisterDTO;
import end_project.new_meetup.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserModelToUserRegisterConverter {

    public UserRegisterDTO convert(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        final UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setName(userModel.getName());
        userRegisterDTO.setEmail(userModel.getEmail());
        userRegisterDTO.setPassword(userModel.getPasswordHash());
        return userRegisterDTO;
    }
    public UserDTO convertForJoinEventUser(UserModel userModel) {

        final UserDTO userDTO= new UserDTO();
        userDTO.setName(userModel.getName());
        userDTO.setEmail(userModel.getEmail());
        return userDTO;
    }
}
