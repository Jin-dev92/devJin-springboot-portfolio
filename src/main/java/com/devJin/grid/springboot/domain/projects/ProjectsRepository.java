package com.devJin.grid.springboot.domain.projects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectsRepository extends JpaRepository<Projects,Long> {

    @Query(value = "SELECT * FROM projects p, files f WHERE f.id = p.file_id AND p.type = 1 ORDER BY p.id DESC" , nativeQuery = true)
    List<Projects> findAllByDesc();

    @Query(value = "SELECT * FROM projects p, files f WHERE f.id = p.file_id AND p.type = 2 ORDER BY p.id DESC" , nativeQuery = true)
    List<Projects> findAllbyDescFromGallery();
}
