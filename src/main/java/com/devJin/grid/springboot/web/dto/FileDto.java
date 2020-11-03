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
    private String originFileName;
    private String fileName;
    private Long fileSize;
    private String filePath;
    private Long projectId;

    @Builder
    public FileDto(String originFileName, String fileName, Long fileSize, String filePath, Long projectId) {
        this.originFileName = originFileName;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.filePath = filePath;
        this.projectId = projectId;
    }

    public Files toEntity(){
        return Files.builder()
                .originFileName(originFileName)
                .fileName(fileName)
                .fileSize(fileSize)
                .filePath(filePath)
                .projectId(projectId)
                .build();
    }
}
