package com.fast87.journal;

import com.fast87.journal.redis.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootJournalApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootJournalApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJournalApplication.class, args);
    }

    @RequestMapping("/")
    public String index(){
        return "스프링 부트 액추에이터";
    }
   /* @Value("${topic}")
    String topic;

    @Bean
    CommandLineRunner sendMessage(Producer producer){
        return args -> {
            producer.sendTo(topic, "스프링 부트 레디스 메시징 시작");
        };
    }
*/
   /* public static void main(String[] args) {
        SpringApplication.run(SpringBootJournalApplication.class, args);
    }

    @Value("${myqueue}")
    String queue;

    @Bean
    Queue queue(){
        return new Queue(queue, false);
    }

    @Autowired
    Producer producer;

    @Scheduled(fixedDelay = 500L)
    public void sendMessages(){
        producer.sendTo(queue, "안녕하세요 !" + new Date());
    }
*/


    /*    @Autowired
    JournalService service;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJournalApplication.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        log.info("@@데이터 생성...");
        service.insertData();
        log.info("@@findAll 호출...");
        service.findAll().forEach(entery -> log.info(entery.toString()));

    }*/


    /*@Value("${myapp.server-ip}")
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
*/
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
			repo.save(new JournalEntry("스프링부트 입문", "오늘부터 스프링 부트 공부하기 시작했다", "01/01/2016"));
			repo.save(new JournalEntry("간단한 스프링 부트 프로젝트", "스프링 부트 프로젝트 만들었다", "01/02/2016"));
			repo.save(new JournalEntry("졸립다", "사실 공부하기 싫다", "01/03/2016"));
			repo.save(new JournalEntry("배고프다", "밥은 먹었는데 그래도 배고프다", "01/04/2016"));
			repo.save(new JournalEntry("그래도 공부를 하자", "먹고 사는게 쉬운일이 아니다", "01/05/2016"));
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
