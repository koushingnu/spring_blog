package com.example.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.blog.mapper")
public class BlogPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogPlatformApplication.class, args);
	}

}
