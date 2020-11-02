package com.devJin.grid.springboot.service.projects;

import com.devJin.grid.springboot.domain.projects.Projects;
import com.devJin.grid.springboot.domain.projects.ProjectsRepository;
import com.devJin.grid.springboot.web.dto.ProjectSaveRequestDto;
import com.devJin.grid.springboot.web.dto.ProjectsListDto;
import com.devJin.grid.springboot.web.dto.ProjectsUpdateRequestDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectsRepository projectsRepository;

    @Transactional
    public Long save(ProjectSaveRequestDto projectSaveRequestDto){
        return projectsRepository.save(projectSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id,ProjectsUpdateRequestDto requestDto){
        Projects projects = projectsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 프로젝트가 없습니다."));
        projects.update(requestDto.getTitle(),requestDto.getSubTitle(),requestDto.getContent(),requestDto.getType(),requestDto.getFileId());
        return id;
    }

    @Transactional
    public void delete(Long id){
        projectsRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<ProjectsListDto> findAllDesc(){
        return projectsRepository.findAllByDesc().stream().map(ProjectsListDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProjectsListDto> findAllbyDescFromGallery(){
        return projectsRepository.findAllbyDescFromGallery().stream().map(ProjectsListDto::new).collect(Collectors.toList());
    }


}