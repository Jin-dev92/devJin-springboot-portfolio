package com.devJin.grid.springboot.web;

import com.devJin.grid.springboot.service.post.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProjectsApiController {
    private final ProjectService projectService;

    // save
    // update
    // delete
}
