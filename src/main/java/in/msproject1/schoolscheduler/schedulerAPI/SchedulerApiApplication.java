package in.msproject1.schoolscheduler.schedulerAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "in.msproject1.schoolscheduler")
public class SchedulerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerApiApplication.class, args);
	}

}
