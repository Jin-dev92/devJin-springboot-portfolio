package com.devJin.grid.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectsUpdateRequestDto {
    private String title;
    private String subTitle;
    private String content;
    private int type;
    private String thumbnail;
    private Long fileId;

    @Builder
    public ProjectsUpdateRequestDto(String title, String subTitle, String content, int type, String thumbnail, Long fileId) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.type = type;
        this.thumbnail = thumbnail;
        this.fileId = fileId;
    }
}
