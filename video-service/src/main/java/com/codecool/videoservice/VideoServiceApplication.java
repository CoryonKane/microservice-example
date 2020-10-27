package com.codecool.videoservice;

import com.codecool.videoservice.model.Video;
import com.codecool.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class VideoServiceApplication {

	@Autowired
	private VideoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(VideoServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CommandLineRunner init() {
		return args -> {
			Video video1 = Video.builder()
					.name("Road to El Dorado best ost")
					.url("https://www.youtube.com/watch?v=3PJg04GPmC8&list=PL_hCriEzAh0qhlOOJO_qwqDcP-YyvXxv3&index=23")
					.build();
			Video video2 = Video.builder()
					.name("Diggy Diggy Hole")
					.url("https://www.youtube.com/watch?v=ytWz0qVvBZ0")
					.build();
			Video video3 = Video.builder()
					.name("Codecool - Microservices with Spring Cloud #4")
					.url("https://www.youtube.com/watch?v=4JUkIM16_Ms&t=927s")
					.build();
			repository.saveAndFlush(video1);
			repository.saveAndFlush(video2);
			repository.saveAndFlush(video3);
		};
	}

}
