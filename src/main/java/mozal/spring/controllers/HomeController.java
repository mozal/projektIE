package mozal.spring.controllers;

import mozal.spring.responses.BasicResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Monika on 2016-04-11.
 */
@RestController
@RequestMapping({"/", "/home"})   //sciezka pod ktora dziala controler
public class HomeController {
    @RequestMapping("/test")
    public BasicResponse test() {
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setText("AHOJ");
        basicResponse.setResult(true);
        return basicResponse;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public BasicResponse test(@RequestBody String text) {
        System.out.println(text);
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setText("AHOJ");
        basicResponse.setResult(true);
        return basicResponse;
    }
}
