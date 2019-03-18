package PetSitters.service;

import PetSitters.entity.User;
import PetSitters.repository.UserRepository;
import PetSitters.schemas.LoginSchema;
import PetSitters.schemas.LogoutSchema;
import PetSitters.schemas.RegisterSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PetSittersService {

    @Autowired
    UserRepository UserRep;

    public User login(LoginSchema login) {
        User user=UserRep.findByUsername(login.getUser());
        return null;
    }

    public void logout(LogoutSchema logout) {
    }

    public void register(RegisterSchema register) {
        User newUser=new User();
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        newUser.setPassword(bCryptPasswordEncoder.encode(register.getPassword()));
        newUser.setUsername(register.getUsername());
        UserRep.save(newUser);
    }
}
