package com.devJin.grid.springboot.web;

import com.devJin.grid.springboot.service.files.FilesService;
import com.devJin.grid.springboot.service.projects.ProjectService;

import com.devJin.grid.springboot.web.dto.ProjectSaveRequestDto;
import com.devJin.grid.springboot.web.dto.ProjectsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.LinkedList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class ProjectsApiController {
    private final ProjectService projectService;
    private final FilesService filesService;
    // save
    @PostMapping(value = "/api/projects",headers = ("content-type=multipart/*"))
    public Long save(ProjectSaveRequestDto requestDto , MultipartHttpServletRequest inputFiles) {
        List<MultipartFile> fileList = inputFiles.getFiles("fileList");
        MultipartFile thumbnail = inputFiles.getFile("thumbnail");
        assert thumbnail != null;
        System.out.println(thumbnail.getOriginalFilename());
        for (MultipartFile mf : fileList){
                System.out.println(mf.getOriginalFilename());
        }

        return projectService.save(requestDto);
//        return null;
    }
    // update
    @PutMapping("/api/project/{id}")
    public Long update(@PathVariable Long id, ProjectsUpdateRequestDto requestDto){
        return projectService.update(id,requestDto);
    }
    // deleteapp
}
