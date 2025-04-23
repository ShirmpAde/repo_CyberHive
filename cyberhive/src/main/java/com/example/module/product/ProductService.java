package com.example.module.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;

@Service
public class ProductService {
//	for aws.s3 fileupload s
	@Autowired
	private AmazonS3Client amazonS3Client;
	
	public int insert(ProductDto productDto) throws Exception { 
    	dao.insert(productDto);
    	uploadFilesToS3(
    			productDto.getUploadImg1()
    			, productDto
    			, "infrBannerUploaded"
    			, productDto.getUploadImg1Type()
    			, productDto.getUploadImg1MaxNumber()
    			, productDto.getIfbnSeq()
    			, dao
    			, amazonS3Client);
    	return 1; 
    }
	
	@Autowired
	ProductDao productDao;
	
	public List<ProductDto> selectList(ProductVo vo){
		return productDao.selectList(vo);
	}
	
	public int selectOneCount(){
		return productDao.selectOneCount();
	}
	
	public Object selectOne(ProductDto productDto) {
		return productDao.selectOne(productDto);
	}
	
	public Object selectOne(ProductVo productVo) {
		return productDao.selectOne(productVo);
	}
	
	public int update(ProductDto productDto) {
		return productDao.update(productDto);
	}
	
	public int delete(ProductDto productDto) {
		return productDao.delete(productDto);
	}
	
	public int uelete(ProductDto productDto) {
		return productDao.uelete(productDto);
	}
	
	public int selectListWithoutPaging(ProductVo productVo) {
		return productDao.selectListWithoutPaging(productVo);
	}
}