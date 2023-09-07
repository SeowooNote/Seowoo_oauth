## OAuth2.0 을 이용한 소셜 미디어 로그인 입니다.(Github 연동 로그인) ##
### oauth-front ###
npx create-react-app {프로젝트 명} --template typescript<br/>
npm run start<br/>

npm install react-router-dom axios react-cookie<br/>
### oauth-back ###
#### spring Initializr(F1) ####
     version : 2.7.15
     Language : java
     Group : com.seowoo
     Name : oauth-back
     Packaging : jar
     Java : 17
     Dependencies : spring web, validation, data jpa, security, oauth2 client, lombok, mysql

yml 형식의 파일은 들여쓰기가 중요(tab)<br/>
localhost:4040 에 접속하면 basic 인증화면이 나옴 -> 안나오게 처리<br/>
build.gradle 파일 dependecies 항목 추가<br/>
https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt 활용<br/>
implementation group: 'io.jsonwebtoken', name: 'jjwt', version: '0.9.1' 추가

|**폴더명**||
|--|--|
|**config**||
|**dto**||
|**entity**||
|**filter**||
|**provider**||
|**service**||
|**implement**||
|**resource**||
|**controller**||
|**handler**|**토큰 생성**|

#### 깃허브 로그인 연결 ####
github -> settings -> developer settings -> OAuth Apps -> Client Id, Client Secret 값 확인 후 설정(yml 파일)<br/>
http://localhost:4040/oauth2/authorization/github -> 인증처리(github 에 요청) -> 응답받아 반환

#### 총정리 ####
0. Spring Security / OAuth2-client 의존성 주입(build.gradle)
1. OAuth 제공자(Github, Kakao, Naver, ...)에서 OAuth application 등록 -> Client id, Client secret key 제공받음
2. Spring 에서 application 설정(application.properties, application.yml 등) -> Spring.security.oauth2.client.registration.{provider}.clientId / clientSecret / redirectionUrl / scope 등록 -> Spring.security.provider.{provider}.authorization-uri / token-uri / user-info-uri 등록
3. WebSecurityConfig 에 .oauth2Login() 추가 -> http://localhost:{port 번호}/oauth2/authorization/{provider} 요청으로 확인
4. WebSecurityConfig 에 .redirectionEndpoint().baseUri("?") [? = oauth application 등록 시 사용했던 redirection url 패턴
5. ApplicationOAuth2User Class 작성
6. OAuth2UserServiceImplement 작성
7. OAuthSuccessHandler 작성
8. WebSecurityConfig 에 and().userInfoEndPoint().userService(OAuth2UserServiceImplement 객체) 추가
9. WebSecurityConfig 에 and().successHandler(oAuthSuccessHandler 객체) 추가
+ oauth 인증 경로 변경 시 -> .redirectionEndpoint().baseUri("?") 다음에 -> .and().authorizationEndpoint().baseUri("변경할 Url 패턴") -> 도메인/변경한 url 패턴/{provider} 로 oauth 인증 시작(ex. http://localhost:4040/api/v1/social/github)

