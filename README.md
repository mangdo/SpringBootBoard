# SpringBootBoard
> SpringBoot Framework를 사용하고 AWS로 배포한 게시판 웹 프로젝트입니다.   
*~~http://ec2-13-124-219-138.ap-northeast-2.compute.amazonaws.com:8080/~~ (현재는 서버를 내린상태입니다.)*

<br>

## 1. 제작 기간 & 참여 인원
+ 2021년 4월 9일 ~ 2021년 4월 17일
+ 개인 프로젝트

## 2. 사용기술

#### `Back-end`
+ Java 8
+ SpringBoot 2.1.7
+ Gradle 4.10.2
+ Spring Data JPA
+ H2
+ Spring Security OAuth2.0

#### `Front-end`
+ Mustache
+ JQuery 3.3.1
+ Bootstrap 4.3.1

#### `test`
+ JUnit

#### `deploy`
+ AWS EC2 (Amazon linux 2)
+ AWS RDS (MariaDB)

## 3. ERD 설계
<img src="https://user-images.githubusercontent.com/70243735/115181276-7e935480-a112-11eb-8cf6-217f7a6e571e.png">

## 4. 실행화면

<img src="https://user-images.githubusercontent.com/70243735/115190105-7d6a2380-a122-11eb-9127-83b03b066aa9.gif">

## 5. 핵심 기능

+ #### 게시글의 CRUD   
  : AJAX와 REST API를 적용하였습니다.   
  <details>
  <summary> CRUD 설명 펼치기:pushpin: </summary>

  **[ 기본 구조 ]**
  <img src = "https://user-images.githubusercontent.com/70243735/115184883-b5b93400-a119-11eb-92d5-101d381bde84.png">
  
  **[ 상세 구조 ]**
  <img src = "https://user-images.githubusercontent.com/70243735/115185384-b30b0e80-a11a-11eb-9fdc-93e4612944f7.png">
  
  + **RestApiController**    
  : 데이터를 반환하는 [RestController](./demo/src/main/java/com/example/demo/web/PostsApiController.java)를 사용하였고, view단의 JQuery의 [ajax](./demo/src/main/resources/static/js/app/index.js)로 데이터를 주고 받습니다.
  
  + **PostsRepository**   
  : JpaRepository를 상속 받아 CRUD 관련 메소드를 제공받습니다.
  
  + **DTO**   
    (1) PostsListResponseDto   
    (2) PostsResponseDto   
    (3) PostSaveRequestDto   
    (4) PostUpdateRequestDto   
      : Posts domain과 흡사하지만, Posts는 데이터 베이스와 맞닿는 핵심클래스입니다.   
        화면변경은 자주 일어나게되는데 이를 위해서 Entity 클래스를 변경할 수는 없으니 DTO를 따로 만들었습니다.

  </details>
  
+ #### 소셜 로그인
  : 구글 로그인과 네이버 로그인을 구현하였습니다.

  <details>
  <summary> 소셜 로그인 설명 펼치기:pushpin: </summary>
  
  **[ 기본 구조 ]**
  <img src ="https://user-images.githubusercontent.com/70243735/115184883-b5b93400-a119-11eb-92d5-101d381bde84.png">
  
  **[ 상세 구조 ]**
  <img src ="https://user-images.githubusercontent.com/70243735/115185038-0466ce00-a11a-11eb-99da-039c96d588de.png">

    + **CustomOAuth2UserService**    
      : OAuth2UserService를 구현하여 소셜 로그인 이후 가져온 사용자의 정보를 기반으로 가입, 정보수정, 세션 저장 등의 추가적인 기능을 수행합니다.    
      : 로그인 성공시 세션에 SessionUser를 저장합니다.

    + **IndexController**   
      : 세션에서 저장해둔 SessionUser를 가져옵니다.

    + **PostsRepository**   
      : JpaRepository를 상속 받아 save(), findByEmail()을 제공받습니다.

    + **DTO**   
      (1) SessionUser
        : User를 세션에 저장하기위해 User를 직렬화하는 클래스   
      (2) OAuthAttributes
        : OAuth2User의 사용자 정보를 담는 클래스
  </details>

## 6. 회고 / 느낀점

