package com.devJin.grid.springboot.domain.files;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface FilesRepository  extends JpaRepository<Files , Long> {
//    @Query(value = "SELECT Max(JOIN_TO_ID) FROM Files f GROUP BY JOIN_TO_ID",nativeQuery = true)
//    Long LastFileCount();
}
