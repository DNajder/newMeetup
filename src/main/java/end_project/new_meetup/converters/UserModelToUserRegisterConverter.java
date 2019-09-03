package end_project.new_meetup.converters;

import end_project.new_meetup.model.UserModel;
import end_project.new_meetup.dto.UserRegisterDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserModelToUserRegisterConverter implements Converter<UserModel, UserRegisterDTO> {
    @Override
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

}
