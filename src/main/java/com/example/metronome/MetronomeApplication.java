package com.example.metronome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("Repository")
public class MetronomeApplication {

	public static void main(String[] args) {

		SpringApplication.run(MetronomeApplication.class, args);
	}


}
