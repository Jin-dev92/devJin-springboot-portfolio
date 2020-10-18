package com.devJin.grid.springboot.domain.projects;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String subTitle;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private int type;
    private String thumbnail;
    private Long fileId;

    @Builder
    public Projects(String title, String subTitle, String content, int type, String thumbnail, Long fileId) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.type = type;
        this.thumbnail = thumbnail;
        this.fileId = fileId;
    }

    public void update(String title, String subTitle, String content, int type, String thumbnail, Long fileId){
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.type = type;
        this.thumbnail = thumbnail;
        this.fileId = fileId;
    }
}
