package com.devJin.grid.springboot.web;

import com.devJin.grid.springboot.domain.projects.ProjectsRepository;
import com.devJin.grid.springboot.service.projects.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class GalleryController {
    private final ProjectService projectService;

    @GetMapping("/gallery")
    public String gallery(Model model){
        model.addAttribute("galleryList",projectService.findAllbyDescFromGallery());
        return "gallery";
    }

}
