package com.devJin.grid.springboot.web.dto;

import com.devJin.grid.springboot.domain.projects.Projects;

import javax.persistence.Column;

public class ProjectsListDto {
    private Long id;
    private String title;
    private String subTitle;
    private String content;
//    private String mainPicture;
//    private String subPicture;

    public ProjectsListDto(Projects projects) {
        this.id = projects.getId();
        this.title = projects.getTitle();
        this.subTitle = projects.getSubTitle();
        this.content = projects.getContent();
//        this.mainPicture = projects.getMainPicture();
//        this.subPicture = projects.getSubPicture();
    }
}
