package mozal.spring.controllers;

import mozal.spring.entities.User;
import mozal.spring.responses.BasicResponse;
import mozal.spring.services.DataBaseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Monika on 2016-04-13.
 */
@RestController
@RequestMapping("/register")
public class RegisterController {
    private static final Logger logger = Logger.getLogger(RegisterController.class);

    @Autowired // konstrukcja obiektu
    private DataBaseService dataBaseService;

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public BasicResponse registerNewUser(@RequestBody User user) {
        BasicResponse response = new BasicResponse();
        if (dataBaseService.findByEmail(user.getEmail()) == null) {
            logger.info("Adding new user");
            System.out.println(user.toString());
            dataBaseService.saveUser(user);
            response.setResult(true);
        } else {
            logger.error("User already exists");
        }

        return response;
    }
}
