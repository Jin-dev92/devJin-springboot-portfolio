package com.devJin.grid.springboot.web;

import com.devJin.grid.springboot.service.files.FilesService;
import com.devJin.grid.springboot.service.projects.ProjectService;

import com.devJin.grid.springboot.web.dto.ProjectSaveRequestDto;
import com.devJin.grid.springboot.web.dto.ProjectsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class ProjectsApiController {
    private final ProjectService projectService;
    private final FilesService filesService;
    // save
    @PostMapping("/api/projects")
    public Long save(@RequestBody ProjectSaveRequestDto requestDto) {
        return projectService.save(requestDto);
    }
    // update
    @PutMapping("/api/project/{id}")
    public Long update(@PathVariable Long id, ProjectsUpdateRequestDto requestDto){
        return projectService.update(id,requestDto);
    }
    // delete
}
