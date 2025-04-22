package com.example.module.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;

@Service
public class S3Service {
//	for aws.s3 fileupload s
	@Autowired
	private AmazonS3Client amazonS3Client;
	
	public int insert(BannerDto dto) throws Exception { 
    	dao.insert(dto);
    	uploadFilesToS3(
    			dto.getUploadImg1()
    			, dto
    			, "infrBannerUploaded"
    			, dto.getUploadImg1Type()
    			, dto.getUploadImg1MaxNumber()
    			, dto.getIfbnSeq()
    			, dao
    			, amazonS3Client);
    	return 1; 
    }
}