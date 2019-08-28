package end_project.new_meetup.mapper;

import end_project.new_meetup.dao.UserModel;
import end_project.new_meetup.dto.UserRegisterDto;
import org.springframework.core.convert.converter.Converter;

public class UserModelToUserRegisterMapper implements Converter<UserModel, UserRegisterDto> {
    @Override
    public UserRegisterDto convert(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        final UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setName(userModel.getName());
        userRegisterDto.setEmail(userModel.getEmail());
        userRegisterDto.setPassword(userModel.getPasswordHash());
        return userRegisterDto;
    }

}
