package PetSitters.service;

import PetSitters.entity.User;
import PetSitters.repository.UserRepository;
import PetSitters.schemas.LoginSchema;
import PetSitters.schemas.LogoutSchema;
import PetSitters.schemas.RegisterSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetSittersService {

    @Autowired
    UserRepository UserRep;

    public User login(LoginSchema login) {
        User test=new User(login.getUser(),login.getPassword());
        test.setId("1");
        UserRep.save(test);
        return UserRep.findByFirstName("why");

    }

    public void logout(LogoutSchema logout) {
    }

    public void register(RegisterSchema register) {
    }
}
