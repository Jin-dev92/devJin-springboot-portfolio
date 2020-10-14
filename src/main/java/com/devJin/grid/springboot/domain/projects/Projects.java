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

    private String mainPicture;
    private String subPicture;

    @Builder
    public Projects(String title, String subTitle, String content, String mainPicture, String subPicture) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.mainPicture = mainPicture;
        this.subPicture = subPicture;
    }

    public void update(String title, String content, String mainPicture, String subPicture){
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.mainPicture = mainPicture;
        this.subPicture = subPicture;
    }
}
