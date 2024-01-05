package ru.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class PathToFiles {

    @Value("${files.upload.path}")
    private String uploadPath;

    @Value("${files.upload.name}")
    private String fileNameUpload;

    @Value("${files.download.path}")
    private String downloadPath;

    @Value("${files.download.name_file}")
    private String fileNameDownload;
}
