package com.example.module.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;

@Service
public class S3Service {
//	for aws.s3 fileupload s
	@Autowired
	private AmazonS3Client amazonS3Client;
	
	public int insert(ProductDto productDto) throws Exception { 
    	dao.insert(productDto);
    	uploadFilesToS3(
    			productDto.getUploadImg1()
    			, bannerDto
    			, "infrBannerUploaded"
    			, productDto.getUploadImg1Type()
    			, productDto.getUploadImg1MaxNumber()
    			, productDto.getIfbnSeq()
    			, dao
    			, amazonS3Client);
    	return 1; 
    }
}