package ru.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
public class PathToFiles {

    @Value("${path.download}")
    private String downloadPath;

    @Value("${path.upload}")
    private String uploadPath;

    @Setter
    @Value("${path.name_file}")
    private String defaultName = "contacts";

    @Setter
    @Value("${is_default_download}")
    private Boolean isDefaultDownload;
}
