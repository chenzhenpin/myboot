package demos.example.code.securityJwt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/login")
    public String toLogin(){

        return "/login";
    }


    @ResponseBody
    @RequestMapping("/sys")
    public String getSys(){

        return "systemManager";
    }
}
