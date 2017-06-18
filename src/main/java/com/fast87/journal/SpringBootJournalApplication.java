package com.fast87.journal;

import com.fast87.journal.domain.Journal;
import com.fast87.journal.repository.JournalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class SpringBootJournalApplication {

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

	}
}
