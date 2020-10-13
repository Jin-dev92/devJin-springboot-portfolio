package com.devJin.grid.springboot.web.dto;

import com.devJin.grid.springboot.domain.projects.Projects;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class ProjectSaveRequestDto {
    private String title;
    private String content;
    private String mainPicture;
    private String subPicture;

    @Builder
    public ProjectSaveRequestDto(String title, String content, String mainPicture, String subPicture) {
        this.title = title;
        this.content = content;
        this.mainPicture = mainPicture;
        this.subPicture = subPicture;
    }

    public Projects toEntity(){ // service 에서 save 메소드를 사용할 때 엔티티로 변환을 해줘야됨
        return   Projects.builder()
                    .title(title)
                    .content(content)
                    .mainPicture(mainPicture)
                    .subPicture(subPicture)
                    .build();
    }
}
