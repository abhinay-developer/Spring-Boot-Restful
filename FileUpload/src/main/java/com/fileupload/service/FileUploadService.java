package com.fileupload.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fileupload.model.FileDto;
import com.fileupload.repository.IFileUploadRepo;

@Service
public class FileUploadService {

	@Autowired
	private IFileUploadRepo fileUploadRepo;

	public FileDto store(MultipartFile file) throws IOException {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		FileDto fileDto = new FileDto(fileName, file.getContentType(), file.getBytes());

		return fileUploadRepo.save(fileDto);

	}

	public FileDto getFile(String id) {
		return fileUploadRepo.findById(id).get();
	}

	public Stream<FileDto> getAllFiles() {
		return fileUploadRepo.findAll().stream();
	}

}
