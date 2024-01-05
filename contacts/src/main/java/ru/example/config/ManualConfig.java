package ru.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import ru.example.service.WorkingMode;

@Configuration
@Profile("manual")
public class ManualConfig implements WorkingMode {
    @Override
    public void run() {

    }
}
