package com.asylzhan.lab5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.asylzhan.lab5")
@PropertySource("application.properties")
@EnableJpaRepositories(basePackages = "com.asylzhan.lab5.repo")
public class SpringConfig {
}
