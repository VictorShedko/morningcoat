package victor.morningcoat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @RequestMapping("/")
    public String index() {
        return "Hello! I'm Victor!";
    }
    @RequestMapping("/secret")
    public String secret() {
        return "Welcome to secret page!";
    }
}
