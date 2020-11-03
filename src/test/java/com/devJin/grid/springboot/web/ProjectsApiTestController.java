package com.devJin.grid.springboot.web;

import com.devJin.grid.springboot.domain.files.Files;
import com.devJin.grid.springboot.domain.projects.Projects;
import com.devJin.grid.springboot.domain.projects.ProjectsRepository;
import com.devJin.grid.springboot.service.projects.ProjectService;
import com.devJin.grid.springboot.web.dto.FileDto;
import com.devJin.grid.springboot.web.dto.ProjectSaveRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectsApiTestController {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    private ProjectsRepository projectsRepository;
    private ProjectService projectService;
    @Before
    public void insertDump(){
        System.out.println("테스트 검증 시작");
/*        ProjectSaveRequestDto saveRequestDto = ProjectSaveRequestDto.builder()
                .title("제목")
                .subTitle("부제목")
                .content("내용")
                .type(1)
                .build();
        projectService.save(saveRequestDto);*/
    }

    @After
    public void tearDown() throws Exception{
        projectsRepository.deleteAll();
    }
    @Test
    public void 프로젝트가_무사히_등록되는지(){
        //given
/*        FileDto fileDto = FileDto.builder()
                .originFileName("ㅇㅇㅇㅇ")
                .fileName("파일이름")
                .fileSize(100)
                .filePath("어딘가엔 저장된다")
                .build();*/
        ProjectSaveRequestDto saveRequestDto = ProjectSaveRequestDto.builder()
                                            .title("제목")
                                            .subTitle("부제목")
                                            .content("내용")
                                            .type(1)
//                                            .files()
                                            .build();
        projectService.save(saveRequestDto);
        //when
        //then
    }

}
