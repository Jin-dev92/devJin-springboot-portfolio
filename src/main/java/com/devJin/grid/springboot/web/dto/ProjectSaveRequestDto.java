package com.devJin.grid.springboot.web.dto;

import com.devJin.grid.springboot.domain.files.Files;
import com.devJin.grid.springboot.domain.projects.Projects;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ProjectSaveRequestDto {
    private Long id;
    private String title;
    private String subTitle;
    private String content;
    private int type; // 가족용 포폴로 사용할지 아니면 개인 포폴로 사용할지
    private List<Files> files;

    @Builder
    public ProjectSaveRequestDto(Long id, String title, String subTitle, String content, int type, List<Files> files) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.type = type;
        this.files = files;
    }

    public Projects toEntity(){ // service 에서 save 메소드를 사용할 때 엔티티로 변환을 해줘야됨
        return   Projects.builder()
                            .id(id)
                            .title(title)
                            .subTitle(subTitle)
                            .content(content)
                            .type(type)
                            .files(files)
                            .build();
    }
}
