package com.example.demo.oauth2;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {
        String errorMessage = "Authentication failed: " + exception.getMessage();
        System.out.println("onAuthenticationFailure@@@ 옴");
        // 로그에 에러 메시지 기록
        System.out.println(errorMessage);

        // 사용자에게 보여줄 에러 메시지 설정
        String encodedErrorMessage = java.net.URLEncoder.encode(errorMessage, "UTF-8");
        response.sendRedirect("/login?error=" + encodedErrorMessage);
    }
}