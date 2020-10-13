package com.devJin.grid.springboot.service.post;

import com.devJin.grid.springboot.domain.projects.Projects;
import com.devJin.grid.springboot.domain.projects.ProjectsRepository;
import com.devJin.grid.springboot.web.dto.ProjectSaveRequestDto;
import com.devJin.grid.springboot.web.dto.ProjectsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectsRepository projectsRepository;

    @Transactional
    public void save(ProjectSaveRequestDto projectSaveRequestDto){
        projectsRepository.save(projectSaveRequestDto.toEntity());
    }

    @Transactional
    public void update(ProjectsUpdateRequestDto dto, Long id){
        Projects projects = projectsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 프로젝트가 없습니다."));
        projects.update(dto.getTitle(),dto.getContent(),dto.getMainPicture(),dto.getSubPicture());
    }

    @Transactional
    public void delete(Long id){
        projectsRepository.deleteById(id);
    }
}
