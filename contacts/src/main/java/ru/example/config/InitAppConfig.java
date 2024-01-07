package ru.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("init")
public class InitAppConfig implements WorkingMode {
    @Override
    public void run() {

    }
}
