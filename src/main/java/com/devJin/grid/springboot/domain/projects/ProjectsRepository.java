package com.devJin.grid.springboot.domain.projects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectsRepository extends JpaRepository<Projects,Long> {

//    @Query("SELECT * FROM projects p ORDER BY p.id DESC")
//    List<Projects> findAllByDesc();
}
