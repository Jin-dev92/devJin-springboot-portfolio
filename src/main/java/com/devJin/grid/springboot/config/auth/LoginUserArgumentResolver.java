package com.devJin.grid.springboot.config.auth;

import com.devJin.grid.springboot.config.auth.dto.LoginUser;
import com.devJin.grid.springboot.config.auth.dto.SessionUser;
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
    /*  HandlerMethodArgumentResolver
    *   조건에 맞는 경우 메소드가 있다면 HandlerMethodArgumentResolver의 구현체가 지정한 값으로
    *   해당 메소드의 파라미터로 넘길수 있습니다.
    * */
    private final HttpSession httpSession;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        /*  컨트롤러 메서드의 특정 파라미터를 지원하는지 판단
        *   여기서는 파라미터에 @LoginUser 어노테이션이 붙어 있고, 파라미터 클래스 타입이 SessionUser.class인경우 true를 반환합니다.
        * */
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;

        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType()); // class.class -> 클래스 자체의 객체를 뽑아낸다.

        return isLoginUserAnnotation && isUserClass;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        /*  파라미터에 전달할 객체를 생성합니다.
        *   여기서는 세션에서 객체를 가져옵니다.
        * */
        return httpSession.getAttribute("user");
    }
}
