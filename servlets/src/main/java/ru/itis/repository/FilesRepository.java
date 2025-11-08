package ru.itis.repository;

import ru.itis.models.FileInfo;

public interface FilesRepository extends CrudRepository<FileInfo>{
    FileInfo findById(Long id);
}
