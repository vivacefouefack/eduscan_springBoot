 package enetAfrica.eduScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EduScanApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduScanApplication.class, args);
	}

}
