 실전 스프링 부트 워크북
=============================

> 도서 : 실전 스프링 부트 워크북 - 한빛 미디어

### 2장 스프링 부트 앱 처녀 개발

1. 스프링 부트 CLI설치()
    - 리눅스, macOS, 솔라리스(macOS기준으로 설명)
        * SDKMAN 설치
            + `curl -s get.sdkman.id | bash`
        * SDK 실행
            + `source "$HOME/.sdkman/bin/sdkman-init.sh"`
            + `sdk version` //버전확인
        * 스프링 부트 CLI 설치
            + `sdk install springboot`
            + `spring --version`//버전확인
        * BREW 설치
            + `/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`
        * 스프링 부트 설치
            + `brew tap pivotal/tap`
            + `install springboot`
    - MAVEN
        * 컴파일, 테스트, 빌드작업에 사용
        * 필요한 의존체를 추가/수정/관리 할수 있음
        * POM.xml파일 필수
        * spring-boot-stater-web 아티펙트 하나만 있어도 spring-core, spring-core, spring-mvc, 내장톰캣서버 그밖의 웹 관련 라이브러리들이 추가된다
    - SpringInitalize
        * http://start.spring.io
        * 필요한 의존체들을 조합해서 스프링부트 프로젝트를 쉽게 구성
        * 전체 폴더구조 및 POM파일 작성
        * 그루비와 자바 중 하나의 언어 선택가능
        * 스프링 부트 버전, 자바 버전 선택가능
       
    - Journal Project
        * web, jpa, H2, thymeleaf를 사용한다
            + web : 웹에 사용되는 의존체
            + jpa : 데이터 퍼시스턴스를 처리할 데이터 기술
                1. JpaRepository는 표지 인터페이스로 스프링 데이터 리포지터리 엔진이 자동 인지 한다
                2. 기본 CRUD 뿐만 아니라 커스텀 메서드 구현에 필요한 프락시 클래스를 제공한다
                2. @Transient를 붙이면, jpa엔진은 값을 저장하지 않고 무시한다
            + H2 : 인메모리 DB엔진
            + thymeleaf : HTML 페이지를 화면에 그릴 템플릿 엔진
        * InitalizingBean은 스프링 엔진이 인스턴스 생성 후 초기화 할 때 항상 호출하는 특수 클래스다
        * saveData메서드는 앱이 시동 준비를 마치기 전에 실행된다
        * @ResponseBody를 붙이는 순간 스프링 MVC는 '응답 메시지를 알맞은 HTTP 메시지 변환기를 써서 JSON으로 변환해야겠구나'라고 알아챈다
        
        >스프링 부트는 @SpringBootApplication과 그 내부의자동구성(@EnableAutoConfiguration) 기능 덕분에 전체 애플리케이션 컴포넌트를 식별합니다 우선 클래스 패스를 조사해서 spring-boot-starter-web 스타터가 선언된 것을 인지한스프링부트는 웹애플리케이션을 구성합니다 .따라서 @RequestMapping이 달린 메서드가 있고 @Controller 애너테이션이 달린 클래스는 웹컨트롤러로 보고 톰켓 서버는 spring-boot-starter-web의 의존체 중 하나이므로 톰캣 서버를 띄웁니다    
  
  
### 3장 스프링부트 자동구성과 주요기능

1. 3.1 자동구성
    - 스프링부트의 핵심기능은 (메이븐이나 그레이들의 파일내용에 따라) 클래스패스, 애너테이션 기타 자바 구성 클래스를 보고 적합한 앱으로 맞춤하는 자동 구성이다.
    - 앱 실행전에 긍정대조와 부정대조를 통해 스프링 부트는 적합한 앱으로 구성한다.
    - 특정 자동 구성 끄기
        * 자동 구성을 끄고 싶으면 @EnableAutoConfiguration의 exclude 파라미터 속성값에 클래스를 명시하면 된다
        * @SpringBootApplication은 @EnableAutoConfiguration, @Configuration, @ComponentScan을 상속한 애너테이션이라 @SpringBootApplication에 exclude파라미터를 쓸수 있다.
2. 3.2 EnableAutoConfiguration과 @Enable<기술명>
    - @EnableAutoConfiguration은 앱에서 필요한 빈을 유추해서 구성하는 클래스
        * 자동구성 클래스는 글래스패스 및 앱에 정의한 빈에 따라 적용 여부 결정
3. 3.3 스프링부트의 주요기능
    - 스프링부트는 실행할 앱의 타입을 유추해서 자동구성하고 어떻게 해서 무엇을 보여줄지 어떤 기능을 켜고 끌지 프로퍼티값으로 커스터마이징 가능한 고도의 맛춤형 프레임워크다
    - 프로젝트 생성
        * `spring init -g=com.fast87.spring -a=spring-boot-simple --package=com.fast87.spring -name=spring-boot-simple -x`
    - @SpringBootAplication
        * @EnableAutoConfiguration, @Configuration, @ComponentScan의 합본
        * SpringApplication은 main 메서드에서 실행할 스프링부트 앱의 부트스트랩 역할을 한다. 실행 클래스를 인자로 넘긴다
    - src/main/resource/banner.txt 파일을 실행 배너로 사용할 수 있다.
        * spring.main.banner-mode=off로 배너를 끌 수 있다.
    - 모든 웹 구성은 메인 스프링 컨텍스트에 의존하므로 반드시 자식으로 선언하고, 부모와 자식 모두 필히 동일한 org.springframework.core.Environment인터페이스를 공유해야한다
    - 스프링 부투 앱에 인자를 넘기, 빈에서 args에 접근할 수 있다.
    - 메이븐 빌드 : `./mvnw package`
    - jar 실행 : `java -jar jar파일명`
    - 인자전달 : `java -jar jar파일명 --containsOption인자명 NonOption인자1 NonOption인자2 `
    - 디버그 모드 : `./mvnw spring-boot:run -Drun.arguments="인자1,인자2""`(,로 인자 구분)
4. 3.4 애플리케이션 구성
    - 스프링부트에서 앱 구성 저장
        * 클래스패스에 application.properties파일을 둔다.(다른 곳에 추가할 수도 있다)
        * YAML표기법에 따라 작성한 application.yml 파일을 클래스 패스에 둔다.(다른 곳에 추가할 수도 있다)
        * 환경변수를 사용한다 클라우드 환경에선 이방법이 기본이다.
        * 터미널 창에 인자로 전달한다.
     - @Value("프로퍼티명")으로 값을 가져올수 있다.
     - 프로퍼티를 찾는 순서
        * 현재 폴더 하위의 /config폴더
        * 현재 폴더
        * 클래스패스 /config 패키지
        * 클래스패스 루트
     - 스프링부트는 바인딩을 느슨하게 처리
        * server.ip = SERVER_IP 처럼 표기법이 달라도 인식
     - @Component @ConfigurationProPerties(prefix="myapp")
        * @ConfigurationProperties는 이 클래스가 application.properties파일에 정의된 모든 프로퍼티 앞에 접두어 myapp을 붙였다고 스프링 부트에 알리는 애너테이션 입니다. 그래서 myapp.serverIp, myapp.name, myapp.description프로퍼티를 올바르게 인식합니다.
        * @Component는 스프링 빈 클래스입을 표시하는 애너테이션입니다.

### 4장 스프링 부트 CLI 

- IDE 없이 프로젝트 생성 및 실행 하는 스프링부트 도구
- 스프링 부트 CLI 설치(mac)
    -  `$brew tap pivotal/tap`
    -  `$brew install springboot` 
    
1. 스프링부트 CLI
    - 실행 : `$spring run ......`
    - 테스트 : `$spring test ......`
    - 의존체 설정 : `$spring grap ......`
    - jar 생성 : `$spring jar ......`
    - war 생성 : `$spring war ......`
    - grap과 비슷, 메이븐 코디네이트 표시: `$spring install ......`
    - 의존체 삭제 : `$spring uninstall ......`
    - 프로젝트 생성 : `$spring init ......`
        * 데모 프로젝트 생성 : `$spring init`
        * 데모 프로젝트 실행 : `$./mvnw spring-boot:run`
        * 그레이들 웹 프로젝트 생성 : `$spring init -d=web,jdbc --build=gradle`
        * -x 옵션으로 바로 압축 해제
    - Shell 명령어
        * `$spring shell`
    - help 명령어
        * `$spring help`
    
### 5장 스프링과 스프링 부트

1. 스프링
    - web.xml 파일의 <servlet>태그에서 서블릿명을 선언하고 <sevlet-mapping>태그에서 요청끝점에 해당하는 url로 서블릿을 맵핑합니다
    - 메이븐 빌드 : `$mvn clean package`
    - 톰캣설치 : `$brew install tomcat`
2. 스프링 부트
    - 애너테이션을 쓰면 xml구성의 군더더기를 들어낼수 있다
    - < context:component-scan>태그는 스프링으로 하여금 base-package 레벨에서 애너테이션으로 표시한 클래스를 찾는다
    - 모든 스프링 기술은 @Enable<기술명> 애너테이션만 있으면 간단히 불러 쓸수 있다.
    
### 6장 스프링부트 테스트

- 인터페이스를 분명하게 설계하고 객체지향적으로 SOLID원칙에 따라 클래스를 작성하는 일은 중요하며 스프링은 이러한 설계원리를 개발자가 더 잘 따르도록 안내하고 필요한 테스트도구를 제공한다
- 단위/통합 테스트 전용 스타터 폼 spring-boot-starter-test만 있으면 된다
- spring-boot-starter-test는 스프링 이니셜라이저로 프로젝트를 생성할 때마다 항상 곁들여지는 스타터 폼으로 spring-test, junit, hamcrest, objnesis, mockito JAR 파일도 함께 가져온다
- @RunWith(SpringJUnit4ClassRunner.class)
    * 제이유닛 라이브러리의 @RunWith는 제이유닛 내장 실행기 대신 SpringJUnit4ClassRunner.class 클래스를 참조하여 테스트를 실행합니다.
- Springboot 1.4
    * SpringRunner
        + SpringJUnit4classRunner를 상속한 클래스로, 사실상 클래스 이름만 짧게 줄인 동일한 클래스다
    * @SpringBootTest
        + 일반적인 스프링 부트 기반의 테스트 클래스에 붙이는 새 애너테이션입니다 속성을 추가해서 애플리케이션에 따라 설정을 달리할 수 있습니다
- 웹테스트
    * @WebAppConfiguration
        + org.springframework.web.context.WebApplicationContext 구현체를 불러오는 클래스 레벨 에너테이션으로, 웹 애플리케이션과 관련된 파일이나 빈은 모두 접근할 수 있습니다

