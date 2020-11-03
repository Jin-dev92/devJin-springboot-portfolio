package com.devJin.grid.springboot.domain.projects;

import com.devJin.grid.springboot.domain.files.Files;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

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
    private int type; // 가족용 포폴로 사용할지 아니면 개인 포폴로 사용할지
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Files.class)
    @JoinColumn(name = "project_id")
    private List<Files> files;

    @Builder
    public Projects(Long id, String title, String subTitle, String content, int type, List<Files> files) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.type = type;
        this.files = files;
    }

    public void update(String title, String subTitle, String content, int type, List<Files> files){
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.type = type;
        this.files = files;
    }
}
