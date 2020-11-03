package com.devJin.grid.springboot.web.dto;

import com.devJin.grid.springboot.domain.files.Files;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ProjectsUpdateRequestDto {
    private String title;
    private String subTitle;
    private String content;
    private int type;
    private List<Files> files;

    @Builder
    public ProjectsUpdateRequestDto(String title, String subTitle, String content, int type, List<Files> files) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.type = type;
        this.files = files;
    }
}
