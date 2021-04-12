package com.example.demo.config.auth;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 어노테이션이 생성될 수 있는 위치 : 파라미터
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 클래스로 지정시킨다
public @interface LoginUser {
    /*
    * @LoginUser이라는 어노테이션을 만든다.
    * */
}
