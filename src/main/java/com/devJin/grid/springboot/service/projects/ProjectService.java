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
//        System.out.println(mtfRequest);
//        List<MultipartFile> fileList = mtfRequest.getFiles("files");
//        String path = "C:\\image\\";
//        File fileDir = new File(path);
//        if (!fileDir.exists())fileDir.mkdirs();
//
//        for (MultipartFile mf : fileList){
//            String originFileName = mf.getOriginalFilename();
//            long fileSize = mf.getSize();
//
//            System.out.println("originFileName : " + originFileName);
//            System.out.println("fileSize : " + fileSize);
//
//            String safeFile = path + System.currentTimeMillis() + originFileName;
//            System.out.println("safeFile : " + safeFile);
//            try {
//                mf.transferTo(new File(safeFile));
//            }
//            catch (IllegalStateException | IOException e) {
//
//                e.printStackTrace();
//            }
//        }

//        try {
//            String origFilename = files.getOriginalFilename();
//            String filename = new MD5Generator(origFilename).toString();
//            /* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
//            String savePath = System.getProperty("user.dir") + "\\files";
//            /* 파일이 저장되는 폴더가 없으면 폴더를 생성합니다. */
//            if (!new File(savePath).exists()) {
//                try{
//                    new File(savePath).mkdir();
//                }
//                catch(Exception e){
//                    e.getStackTrace();
//                }
//            }
//            String filePath = savePath + "\\" + filename;
//            files.transferTo(new File(filePath));
//            Long fileId = filesService.saveFile(
//                    FileDto.builder()
//                    .filePath(filePath)
//                    .originFileName(origFilename)
//                    .fileName(filename)
//                    .fileSize(files.getSize())
//                    .build());
//            projectSaveRequestDto.setFileId(fileId);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
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