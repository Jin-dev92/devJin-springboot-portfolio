package com.devJin.grid.springboot.web;

import com.devJin.grid.springboot.service.files.FilesService;
import com.devJin.grid.springboot.service.projects.ProjectService;

import com.devJin.grid.springboot.web.dto.ProjectSaveRequestDto;
import com.devJin.grid.springboot.web.dto.ProjectsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@RestController
@RequiredArgsConstructor
public class ProjectsApiController {
    private final ProjectService projectService;
    private final FilesService filesService;
    // save
    @PostMapping(value = "/api/projects",headers = ("content-type=multipart/*"))
    public Long save(ProjectSaveRequestDto requestDto , @RequestPart(value = "thumbnail",required = false)MultipartFile thumbnail, @RequestPart(value = "fileList",required = false) MultipartHttpServletRequest files) {
        return projectService.save(requestDto,thumbnail,files);
    }
    // update
    @PutMapping("/api/project/{id}")
    public Long update(@PathVariable Long id, ProjectsUpdateRequestDto requestDto){
        return projectService.update(id,requestDto);
    }
    // deleteapp
}
