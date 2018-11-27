package demos.example.code.securityJwt.handler;

import com.alibaba.fastjson.JSON;
import demos.example.code.securityJwt.bean.AjaxResponseBody;
import demos.example.code.securityJwt.config.MyUserDetails;
import demos.example.code.securityJwt.utils.JwtTokenUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        AjaxResponseBody responseBody = new AjaxResponseBody();

        responseBody.setStatus("00");
        responseBody.setMsg("Login Success!");

        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();


        String jwtToken = JwtTokenUtil.generateToken(myUserDetails.getUsername(), 300);
        responseBody.setJwtToken(jwtToken);

        response.getWriter().write(JSON.toJSONString(responseBody));
    }
}
