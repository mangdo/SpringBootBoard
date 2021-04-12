package com.example.demo.config.auth;

import com.example.demo.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final HttpSession httpSession;
    /*
    * HandlerMethodArgumentResolver는
    * supportsParameter()에서 정의해준 조건의 파라미터를
    * resolveArgument()에서 반환하는 값으로 대체시켜준다.
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //조건에 맞는 파라미터인가를 체크

        // 파라미터에 @LoginUser어노테이션이 있고
        boolean isLoginUserAnnotaion = parameter.getParameterAnnotation(LoginUser.class) != null;

        // 파라미터 클래스 타입이 SessionUser.class라면!
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());

        return isLoginUserAnnotaion && isUserClass;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // 조건에 맞다면 파라미터에 전달할 객체를 생성

        return httpSession.getAttribute("user");
        // 여기서는 세션에서 user 객체를 가져온다.
    }
}
