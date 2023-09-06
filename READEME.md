## OAuth2.0 을 이용한 소셜 미디어 로그인 입니다. ##
### oauth-front ###
npx create-react-app {프로젝트 명} --template typescript<br/>
npm run start
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
