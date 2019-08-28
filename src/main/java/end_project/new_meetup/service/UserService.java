package end_project.new_meetup.service;

import end_project.new_meetup.dao.UserModel;
import end_project.new_meetup.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Iterable<UserModel> findAllUsers(){
        return userRepository.findAll();
    }

    public Optional<UserModel> findUserById(Long id){
        return userRepository.findById(id);
    }
    public UserModel saveUser(UserModel userModel){
        return userRepository.save(userModel);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}