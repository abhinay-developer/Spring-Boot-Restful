package com.fileupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fileupload.model.FileDto;

@Repository
public interface IFileUploadRepo  extends  JpaRepository<FileDto, String>{
	

}
