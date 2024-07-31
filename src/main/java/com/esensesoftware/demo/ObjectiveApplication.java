package com.esensesoftware.demo;

import com.esensesoftware.demo.config.CorsConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
@Slf4j
@EnableCaching
@Import(CorsConfig.class)
@SpringBootApplication
public class ObjectiveApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ObjectiveApplication.class, args);
	}
	@Value("${application.version}")
	private String version;
	@Override
	public void run(String... args) {
		log.info("\nApplication is running at {}\nzone = {}\nJava version = {}\nJava VM = {}\nApplication version = {}",
				LocalDateTime.now(), ZonedDateTime.now().getZone(), System.getProperty("java.version"), System.getProperty("java.vm.name"), version);
	}//run

}//ObjectiveApplication
