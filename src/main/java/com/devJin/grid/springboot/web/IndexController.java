package com.devJin.grid.springboot.web;

import com.devJin.grid.springboot.config.auth.dto.SessionUser;
import com.devJin.grid.springboot.service.projects.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/* 로그인 부터 시작합니다.
* header, footer도 여기서 처리합니다.
* */
@RequiredArgsConstructor
@Controller
public class IndexController {
    private final ProjectService projectService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("pjList",projectService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user"); // CustomOAuth2UserService 에서 로그인 성공 시 세션에 SessionUser를 저장하도록 구성, 로그인 성공시 httpSession.getAttribute("user")에서 값을 가져 올 수 있씁니다.
        if (user != null)   model.addAttribute("userName",user.getName());
        System.out.println("@@@@@@@@@@@user@@@@@@@@@@"+user);
        return "index";
    }
//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }

    @GetMapping("/project-save")
    public String ProjectSave(){
        return "project-save";
    }
}
