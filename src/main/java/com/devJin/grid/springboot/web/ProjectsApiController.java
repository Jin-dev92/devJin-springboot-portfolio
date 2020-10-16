package com.devJin.grid.springboot.web;

import com.devJin.grid.springboot.service.files.FilesService;
import com.devJin.grid.springboot.service.projects.ProjectService;
import com.devJin.grid.springboot.util.MD5Generator;
import com.devJin.grid.springboot.web.dto.FileDto;
import com.devJin.grid.springboot.web.dto.ProjectSaveRequestDto;
import com.devJin.grid.springboot.web.dto.ProjectsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequiredArgsConstructor
public class ProjectsApiController {
    private final ProjectService projectService;
    private final FilesService filesService;
    // save
    @PostMapping("/api/projects")
    public Long save(@RequestBody ProjectSaveRequestDto requestDto , @RequestParam("files") MultipartFile files) {
        try {
            String originFileName = files.getOriginalFilename();
            long fileSize = files.getSize();
            assert originFileName != null;
            String filename = new MD5Generator(originFileName).toString();
            /* 실행되는 위치의 'files' 폴더에 파일이 생성 됩니다.*/
            String savePath = System.getProperty("user.dir") + "\\files";
            System.out.println("+++++++++++save path++++++++++++++");
            System.out.println(savePath);
            /* 파일이 저장되는 폴더가 없으면 폴더를 생성합니다. */
            if (!new File(savePath).exists()){
                try {
                  new File(savePath).mkdir();
                }catch (Exception e){
                    e.getStackTrace();
                }
            }
            String filePath = savePath + "\\" + filename;
            files.transferTo(new File(filePath));

            FileDto fileDto = FileDto.builder()
                    .originFileName(originFileName)
                    .fileName(filename)
                    .filePath(filePath)
                    .build();

            Long fileId = filesService.saveFile(fileDto);
            requestDto.setFileId(fileId);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        return projectService.save(requestDto);
    }
    // update
    @PutMapping("/api/project/{id}")
    public Long update(@PathVariable Long id, ProjectsUpdateRequestDto requestDto){
        return projectService.update(id,requestDto);
    }
    // delete
}
