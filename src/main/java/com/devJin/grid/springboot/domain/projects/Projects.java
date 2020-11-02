package com.devJin.grid.springboot.domain.projects;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

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
    //@ColumnDefault("1")
    private int type; // 가족용 포폴로 사용할지 아니면 개인 포폴로 사용할지
    @Column(nullable = false)
    private Long fileId; // 많은 이미지 파일을 묶기 위해서 id를 사용

    @Builder
    public Projects(String title, String subTitle, String content, int type, Long fileId) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.type = type;
        this.fileId = fileId;
    }

    public void update(String title, String subTitle, String content, int type, Long fileId){
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.type = type;
        this.fileId = fileId;
    }
}
