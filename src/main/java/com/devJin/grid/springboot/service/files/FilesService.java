package com.devJin.grid.springboot.service.files;

import com.devJin.grid.springboot.domain.files.Files;
import com.devJin.grid.springboot.domain.files.FilesRepository;
import com.devJin.grid.springboot.web.dto.FileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FilesService {
    private final FilesRepository filesRepository;

    @Transactional
    public Long saveFile(FileDto fileDto){
        return filesRepository.save(fileDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public FileDto getFile(Long id){
        Files files = filesRepository.findById(id).get();

        return FileDto.builder()
                .originFileName(files.getOriginFileName())
                .fileName(files.getFileName())
                .fileSize(files.getFileSize())
                .build();
    }
//    @Transactional(readOnly = true)
//    public Long lastFileCount() {
//        return filesRepository.LastFileCount();
//    }
}
