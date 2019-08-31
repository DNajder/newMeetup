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

    public RoleModel createDefaultRoles() {
        RoleModel roleModel = new RoleModel();
        roleModel.setRoleName(RoleName.USER);
        if(!roleRepository.findByRoleName(RoleName.USER).isPresent()) {
            roleRepository.save(roleModel);
        }
        else {
            roleModel =roleRepository.findByRoleName(RoleName.USER).get();

        }
        return roleModel;
    }
}