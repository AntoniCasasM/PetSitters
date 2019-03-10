package PetSitters.controller;

import PetSitters.schemas.LoginSchema;
import PetSitters.service.PetSittersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "Login", method = RequestMethod.POST)
    @ApiOperation(value = "Login process.")
    public ResponseEntity addBatch(@RequestBody LoginSchema login) throws IOException {
        PSS.login(login);
        return new ResponseEntity(HttpStatus.OK);
    }

}

