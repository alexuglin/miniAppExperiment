package ru.example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.example.exception.WrongCommandException;
import ru.example.mapper.LinesMapper;
import ru.example.model.Command;

import java.util.List;
import java.util.Objects;

import static ru.example.model.enumeration.NameCommand.EXIT;

@Component
@RequiredArgsConstructor
public class ConsoleHandler implements Handler<Command> {

    private LinesReader linesReader;

    private LinesMapper linesMapper;

    private CommandPerformer commandPerformer;

    public void handle() {
        System.out.println("Введите команду для работы с контактами, для справки наберите HELP");
        List<String> lines;
        Command command = null;
        do {
            lines = linesReader.get(System.in);
            try {
                command = linesMapper.convert(lines.get(0));
            } catch (WrongCommandException e) {
                System.out.println(e.getMessage());
                continue;
            }
            commandPerformer.execute(command);
        } while (Objects.nonNull(command) && command.getName() == EXIT);
    }
}
