package demos.example.code.securityJwt.handler;

import com.alibaba.fastjson.JSON;
import demos.example.code.securityJwt.bean.AjaxResponseBody;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        AjaxResponseBody responseBody = new AjaxResponseBody();

        responseBody.setStatus("02");
        responseBody.setMsg("Login Failure!");

        response.getWriter().write(JSON.toJSONString(responseBody));
    }
}
