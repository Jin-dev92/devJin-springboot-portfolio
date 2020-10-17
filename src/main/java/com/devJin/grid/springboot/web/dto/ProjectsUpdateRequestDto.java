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
    private Long fileId;
    private String thumbnail;

    @Builder
    public ProjectsUpdateRequestDto(String title, String subTitle, String content, Long fileId, String thumbnail) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.fileId = fileId;
        this.thumbnail = thumbnail;
    }
}
