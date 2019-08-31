package end_project.new_meetup.service;

import end_project.new_meetup.model.RoleModel;
import end_project.new_meetup.model.RoleName;
import end_project.new_meetup.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public RoleModel createRoles(RoleName roleName) {
        RoleModel simpleUser = new RoleModel();
        simpleUser.setRoleName(roleName);
        if(roleRepository.findByRoleName(roleName).isPresent()) {
            roleRepository.save(simpleUser);
        }
        return simpleUser;
    }
    public RoleModel createDefaultRoles() {
        RoleModel simpleUser = new RoleModel();
        simpleUser.setRoleName(RoleName.USER);
        if(roleRepository.findByRoleName(RoleName.USER).isPresent()) {
            roleRepository.save(simpleUser);
        }
        return simpleUser;
    }
}