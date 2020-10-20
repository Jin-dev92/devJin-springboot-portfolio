package com.devJin.grid.springboot.service.projects;

import com.devJin.grid.springboot.domain.files.Files;
import com.devJin.grid.springboot.domain.files.FilesRepository;
import com.devJin.grid.springboot.domain.projects.Projects;
import com.devJin.grid.springboot.domain.projects.ProjectsRepository;
import com.devJin.grid.springboot.service.files.FilesService;
import com.devJin.grid.springboot.util.MD5Generator;
import com.devJin.grid.springboot.web.dto.FileDto;
import com.devJin.grid.springboot.web.dto.ProjectSaveRequestDto;
import com.devJin.grid.springboot.web.dto.ProjectsListDto;
import com.devJin.grid.springboot.web.dto.ProjectsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectsRepository projectsRepository;
    private final FilesRepository filesRepository;
    private final FilesService filesService;
    @Transactional
    public Long save(ProjectSaveRequestDto projectSaveRequestDto){
        return projectsRepository.save(projectSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id,ProjectsUpdateRequestDto requestDto){
        Projects projects = projectsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 프로젝트가 없습니다."));
        projects.update(requestDto.getTitle(),requestDto.getSubTitle(),requestDto.getContent(),requestDto.getType(),requestDto.getThumbnail(),requestDto.getFileId());
        return id;
    }

    @Transactional
    public void delete(Long id){
        projectsRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<ProjectsListDto> findAllDesc(){
//        return projectsRepository.findAllByDesc().stream().map(ProjectsListDto::new).collect(Collectors.toList());
        return null;
    }
}