package ru.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("ru.example")
@Configuration
@PropertySource("classpath:application.yml")
public class DefaultConfig {
}
