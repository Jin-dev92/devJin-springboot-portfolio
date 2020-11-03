package com.devJin.grid.springboot.web;

import com.devJin.grid.springboot.service.files.FilesService;
import com.devJin.grid.springboot.service.projects.ProjectService;

import com.devJin.grid.springboot.web.dto.FileDto;
import com.devJin.grid.springboot.web.dto.ProjectSaveRequestDto;
import com.devJin.grid.springboot.web.dto.ProjectsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class ProjectsApiController {
    private final ProjectService projectService;
    private final FilesService filesService;
    private final String filePath = "C:\\image\\";
//    private final String filePath = "/img/upload/";
    // save
    @PostMapping(value = "/api/projects",   headers = ("content-type=multipart/*"))
    public Long save(ProjectSaveRequestDto requestDto , MultipartHttpServletRequest inputFiles) {
        List<MultipartFile> fileList = inputFiles.getFiles("fileList");
        File fileDir = new File(filePath);
        if (!fileDir.exists())fileDir.mkdirs();
        //assert thumbnail != null;
        for (MultipartFile mf : fileList){
            String originFileName = mf.getOriginalFilename();
            long fileSize = mf.getSize();
            String fileName = System.currentTimeMillis() + originFileName;
            String safeFile = filePath + fileName;
            try {
                mf.transferTo(new File(safeFile)); // 파일을 서버에 복사
                filesService.saveFile( // 파일 정보를 데이터 베이스에 저장
                        FileDto.builder()
                                .originFileName(originFileName)
                                .fileName(fileName)
                                .fileSize(fileSize)
                                .filePath(filePath+fileName)
                                .projectId(requestDto.getId())
                                .build());
            }
            catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
        return projectService.save(requestDto);
    }
    // update
    @PutMapping("/api/project/{id}")
    public Long update(@PathVariable Long id, ProjectsUpdateRequestDto requestDto){
        return projectService.update(id,requestDto);
    }
    // deleteapp


}
