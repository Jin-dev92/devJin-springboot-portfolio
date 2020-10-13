package com.devJin.grid.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectsUpdateRequestDto {
    private String title;
    private String content;
    private String mainPicture;
    private String subPicture;

    @Builder
    public ProjectsUpdateRequestDto(String title, String content, String mainPicture, String subPicture) {
        this.title = title;
        this.content = content;
        this.mainPicture = mainPicture;
        this.subPicture = subPicture;
    }
}