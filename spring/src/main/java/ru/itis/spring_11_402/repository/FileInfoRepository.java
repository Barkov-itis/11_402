package ru.itis.spring_11_402.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import ru.itis.spring_11_402.models.FileInfo;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findByStorageFileName (String fileName);
}
