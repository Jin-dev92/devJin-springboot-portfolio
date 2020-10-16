package com.devJin.grid.springboot.domain.files;


import com.devJin.grid.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Files extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "project_id")
    private Long id;
    @Column(nullable = false)
    private String fileName;
    @Column(nullable = false)
    private String fileSize;

    public Files(String fileName, String fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }
}
