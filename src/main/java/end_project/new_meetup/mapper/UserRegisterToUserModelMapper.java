package end_project.new_meetup.mapper;

import end_project.new_meetup.dao.UserModel;
import end_project.new_meetup.dto.UserRegisterDTO;
import org.springframework.core.convert.converter.Converter;

public class UserRegisterToUserModelMapper implements Converter<UserRegisterDTO, UserModel> {
    @Override
    public UserModel convert(UserRegisterDTO userRegisterDto) {
        if (userRegisterDto == null){return null;}

        final UserModel userModel = new UserModel();
        userModel.setName(userRegisterDto.getName());
        userModel.setEmail(userRegisterDto.getEmail());
        userModel.setPasswordHash(userRegisterDto.getPassword());
        return userModel;
    }
}
