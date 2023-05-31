package com.example.Greenstitch;

import com.example.Greenstitch.properties.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(AppProperties.class)
@SpringBootApplication
public class Greenstitch {

	public static void main(String[] args) {
		SpringApplication.run(Greenstitch.class, args);
	}

}
