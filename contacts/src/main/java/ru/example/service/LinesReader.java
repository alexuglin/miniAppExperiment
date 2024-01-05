package ru.example.service;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class LinesReader {

    public List<String> get(Reader reader) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            return getLines(bufferedReader);
        }
    }

    private List<String> getLines(BufferedReader reader) {
        return Objects.isNull(reader) ? Collections.emptyList() : reader.lines().collect(Collectors.toList());
    }
}
