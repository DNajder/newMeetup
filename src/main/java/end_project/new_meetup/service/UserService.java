package end_project.new_meetup.service;

import end_project.new_meetup.converters.UserModelToUserRegisterConverter;
import end_project.new_meetup.dto.UserDTO;
import end_project.new_meetup.model.UserModel;
import end_project.new_meetup.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserModelToUserRegisterConverter userModelToUserRegisterConverter;

    public UserService(UserRepository userRepository, UserModelToUserRegisterConverter userModelToUserRegisterConverter) {
        this.userRepository = userRepository;
        this.userModelToUserRegisterConverter = userModelToUserRegisterConverter;
    }


    public Iterable<UserModel> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserModel> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public UserModel saveUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public List<UserModel> findAllUserByEventId(String id) {
        return userRepository.findAllByEventId(id);
    }

    public Optional<UserModel> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public List<UserDTO> dispalyUserByEventId(String id) {
        List<UserModel> userModels = new ArrayList<>(findAllUserByEventId(id));
        return userModels.stream().map(userModelToUserRegisterConverter::convertForJoinEventUser).collect(Collectors.toList());
    }
}