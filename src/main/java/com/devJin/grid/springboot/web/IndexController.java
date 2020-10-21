package com.devJin.grid.springboot.web;

import com.devJin.grid.springboot.service.projects.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/* 로그인 부터 시작합니다.
*
* */
@RequiredArgsConstructor
@Controller
public class IndexController {
    private final ProjectService projectService;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("pjList",projectService.findAllDesc());
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/user-join")
    public String userJoin(){
        return "user-join";
    }

    @GetMapping("/project-save")
    public String ProjectSave(){
        return "project-save";
    }
}
