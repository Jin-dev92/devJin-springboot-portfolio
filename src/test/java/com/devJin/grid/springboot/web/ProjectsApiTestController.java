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
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectsApiTestController {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Mock
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
        String filePath = "c:/image";
        File fileDir = new File(filePath);
        if (!fileDir.exists())fileDir.mkdirs();

        FileDto fileDto = FileDto.builder()
                .originFileName("ㅇㅇㅇㅇ")
                .fileName("ㅇㅇㅇㅇ.txt")
                .fileSize(10L)
                .filePath(filePath)
                .build();
        FileDto fileDto2 = FileDto.builder()
                .originFileName("dddd")
                .fileName("dddd.txt")
                .fileSize(10L)
                .filePath(filePath)
                .build();
        List<Files> filesList = new ArrayList<Files>();
        filesList.add(fileDto.toEntity());
        filesList.add(fileDto2.toEntity());

        ProjectSaveRequestDto saveRequestDto = ProjectSaveRequestDto.builder()
                                            .title("제목")
                                            .subTitle("부제목")
                                            .content("내용")
                                            .type(1)
                                            .files(filesList)
                                            .build();
        projectService.save(saveRequestDto);
        //when

        //then
    }

}
