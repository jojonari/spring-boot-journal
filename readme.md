 실전 스프링 부트 워크북
=============================

### 2장 스프링 부트 앱 처녀 개발

> 도서 : 실전 스프링 부트 워크북 - 한빛 미디어

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
  