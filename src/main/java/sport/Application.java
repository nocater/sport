package sport;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 		//same as @Configuration @EnableAutoConfiguration @ComponentScan
@MapperScan("sport.dao")	//扫描包下文件
//@Slf4j					//日志
public class Application {
	private final static Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("===Sport started!===");
	}
	
}
