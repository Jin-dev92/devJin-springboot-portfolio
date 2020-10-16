package com.devJin.grid.springboot.web.dto;

import com.devJin.grid.springboot.domain.files.Files;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.File;

@NoArgsConstructor
@Getter
public class FileDto {
    private Long id;
    private String originFileName;
    private String fileName;
    private Long fileSize;
    private String filePath;

    @Builder
    public FileDto(String originFileName, String fileName, Long fileSize, String filePath) {
        this.originFileName = originFileName;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.filePath = filePath;
    }

    public Files toEntity(){
        return Files.builder()
                .fileName(fileName)
                .fileSize(fileSize)
                .originFileName(originFileName)
                .build();
    }
}
