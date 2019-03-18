package PetSitters.controller;

import PetSitters.entity.User;
import PetSitters.schemas.LoginSchema;
import PetSitters.schemas.LogoutSchema;
import PetSitters.schemas.RegisterSchema;
import PetSitters.service.PetSittersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/petsitters")
@Api(value = "PetSittersApi", produces = MediaType.APPLICATION_JSON_VALUE)
public class PetSittersController {

    @Autowired
    PetSittersService PSS;


    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ApiOperation(value = "Login process.")
    public ResponseEntity<User> login(@RequestBody LoginSchema login) throws IOException {
        User us=PSS.login(login);
        return new ResponseEntity(us,HttpStatus.OK);
    }
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    @ApiOperation(value = "Logout process.")
    public ResponseEntity<User> logout(@RequestBody LogoutSchema logout) throws IOException {
        PSS.logout(logout);
        return new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ApiOperation(value = "Register process.")
    public ResponseEntity<User> register(@RequestBody RegisterSchema register) throws IOException {
        PSS.register(register);
        return new ResponseEntity(HttpStatus.OK);
    }

}

