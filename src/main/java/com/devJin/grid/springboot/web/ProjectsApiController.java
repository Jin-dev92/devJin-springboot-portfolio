package com.devJin.grid.springboot.web;

import com.devJin.grid.springboot.service.projects.ProjectService;
import com.devJin.grid.springboot.web.dto.ProjectSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProjectsApiController {
    private final ProjectService projectService;
    // save
    @PostMapping("/api/projects")
    public Long save(@RequestBody ProjectSaveRequestDto requestDto) {
        return projectService.save(requestDto);
    }
    // update

    // delete
}
