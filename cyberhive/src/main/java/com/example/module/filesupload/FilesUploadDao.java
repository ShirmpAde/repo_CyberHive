package com.example.module.filesupload;

import org.springframework.stereotype.Repository;

@Repository
public interface FilesUploadDao {

	public int insert(FilesUploadDto dto);
	
	public int insertUploaded(FilesUploadDto dto);
	
	public int uelete(FilesUploadDto dto);
	
	public FilesUploadDto selectOne(FilesUploadDto dto);
}
