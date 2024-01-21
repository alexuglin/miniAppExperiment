package ru.example.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.example.model.Command;
import ru.example.service.handler.Handler;

@Configuration
@Profile("manual")
@RequiredArgsConstructor
public class ManualAppConfig implements WorkingMode {

    private final Handler<Command> consoleHandler;
    @Override
    public void run() {
        consoleHandler.handle();
    }
}
