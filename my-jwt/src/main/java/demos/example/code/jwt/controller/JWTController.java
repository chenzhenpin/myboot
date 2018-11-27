package demos.example.code.jwt.controller;

import demos.example.code.jwt.common.IJWTInfo;
import demos.example.code.jwt.common.JWTHelper;
import demos.example.code.jwt.common.JWTInfo;
import demos.example.code.jwt.common.RsaKeyHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Controller
public class JWTController {
    Map<String, byte[]> keys = null;
    @RequestMapping("login")
    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        String token = null;
        if (username.equals("chen") && password.equals("33")) {
            JWTInfo info = new JWTInfo(username, "2132132", "user");
            try {
                keys = RsaKeyHelper.generateKey("userkey");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            try {
                token = JWTHelper.generateToken(info, keys.get("pri"), 20);//过期时间固定不变
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return token;
    }
    @RequestMapping("verify")
    @ResponseBody
    public IJWTInfo verify(String token){
        IJWTInfo info=null;
        if(token!=null){
            try {
                info= JWTHelper.getInfoFromToken(token,keys.get("pub"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return info;
    }
    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "index";
    }
}
