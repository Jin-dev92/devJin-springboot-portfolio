package com.devJin.grid.springboot.domain.files;


import com.devJin.grid.springboot.domain.BaseTimeEntity;
import com.devJin.grid.springboot.domain.projects.Projects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Files extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String originFileName;
    @Column(nullable = false)
    private String fileName;
    @Column(nullable = false)
    private Long fileSize;
    @Column(nullable = false)
    private String filePath;
    @Column(nullable = false)
    private Long projectId;

    @Builder
    public Files(String originFileName, String fileName, Long fileSize, String filePath, Long projectId) {
        this.originFileName = originFileName;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.filePath = filePath;
        this.projectId = projectId;
    }
}
