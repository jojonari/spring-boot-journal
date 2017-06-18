package com.fast87.journal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringBootJournalApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringBootJournalApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJournalApplication.class);
    }
    @Value("${myapp.server-ip}")
    String serverIp;

    @Autowired
    MyAppProperties props;

    @Bean
    CommandLineRunner values(){
        return args -> {
            log.info(">>> 서버 IP : " + serverIp);
            log.info(">>> 앱이름 : " + props.getName());
            log.info(">>> 앱 정보 : " + props.getDescription());

        };
    }

    @Component
    @ConfigurationProperties(prefix = "myapp")
    public static class MyAppProperties{
        private String name;
        private String description;
        private String serverIp;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getServerIp() {
            return serverIp;
        }

        public void setServerIp(String serverIp) {
            this.serverIp = serverIp;
        }
    }

    /*
    //클래스버전 2
    private static final Logger log = LoggerFactory.getLogger(SpringBootJournalApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJournalApplication.class);
    }

    @Bean
    String info(){
        return "그냥 간단한 문자열 반환";
    }

    @Autowired
    String info;

    @Bean
    CommandLineRunner myMethod(){
        return args -> {
            log.info("## >> CommandLineRunner 구현체...");
            log.info("## >> info 빈에 엑세스. " + info);
            for (String arg:args)
                log.info(arg);
        };
    }*/

    /*//클래스 버전 11
public class SpringBootJournalApplication implements CommandLineRunner, ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringBootJournalApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJournalApplication.class);
    }

    @Bean
    String info(){
        return "그냥 간단한 문자열 반환";
    }

    @Autowired
    String info;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("## >> ApplicationRunner 구현체..");
        log.info("## >> info 빈에 엑세스. " + info);
        args.getNonOptionArgs().forEach(file -> log.info(file));
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("## >> CommandLineRunner 구현체...");
        log.info("## >> info 빈에 엑세스. " + info);
        for (String arg:args)
            log.info(arg);
    }*/

    /*
    // 클래스 버전 10
	@Bean
	InitializingBean saveData(JournalRepository repo){
		return ()->{
			repo.save(new Journal("스프링부트 입문", "오늘부터 스프링 부트 공부하기 시작했다", "01/01/2016"));
			repo.save(new Journal("간단한 스프링 부트 프로젝트", "스프링 부트 프로젝트 만들었다", "01/02/2016"));
			repo.save(new Journal("졸립다", "사실 공부하기 싫다", "01/03/2016"));
			repo.save(new Journal("배고프다", "밥은 먹었는데 그래도 배고프다", "01/04/2016"));
			repo.save(new Journal("그래도 공부를 하자", "먹고 사는게 쉬운일이 아니다", "01/05/2016"));
		};
	}

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(SpringBootJournalApplication.class);
		new SpringApplicationBuilder()
				.listeners(event -> logger.info("### >> " + event.getClass().getCanonicalName()))
				.sources(SpringBootJournalApplication.class)
				.run(args);
	}

	@Component
	class MyComponent{
		private final Logger logger2 = LoggerFactory.getLogger(SpringBootJournalApplication.class);

		@Autowired
		public MyComponent(ApplicationArguments args) {
			boolean enable = args.containsOption("enable");
			if (enable)
				logger2.info("## >> enable 옵션을 주셨네요.");

			List<String> _args = args.getNonOptionArgs();
			logger2.info("## >> 다른인자들..");
			if (!_args.isEmpty()){
				_args.forEach(file -> logger2.info(file));
			}
		}

	}*/


}
