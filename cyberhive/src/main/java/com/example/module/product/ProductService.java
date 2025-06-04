package com.example.module.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.example.module.filesupload.FilesUploadDao;
import com.example.module.filesupload.FilesUploadService;

@Service
public class ProductService extends FilesUploadService {
	@Autowired
	ProductDao productDao;
	
	@Autowired
	private AmazonS3Client amazonS3Client;
	
	@Autowired
	FilesUploadDao filesUploadDao;
	
	public List<ProductDto> selectList(ProductVo vo){
		return productDao.selectList(vo);
	}
	
	public int selectOneCount(ProductVo Vo) {
		return productDao.selectOneCount(Vo);
	}
	
	public ProductDto selectOne(ProductDto productDto) {
		return productDao.selectOne(productDto);
	}
	
	public ProductDto selectOne(ProductVo Vo) {
		return productDao.selectOne(Vo);
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
	
	public List<ProductDto> selectListProduct() {
		return productDao.selectListProduct();
	}
	
	public int selectListWithoutPaging(ProductVo productVo) {
		return productDao.selectListWithoutPaging(productVo);
	}
	
	public int insert(ProductDto productDto) throws Exception {
		productDao.insert(productDto);
		uploadFilesToS3(
				productDto.getUploadImg1()
			, productDto
			, "infrBannerUploaded"
			, productDto.getUploadImg1Type()
			, productDto.getUploadImg1MaxNumber()
			, productDto.getSeq()
			, filesUploadDao
			, amazonS3Client);
	return 1;
	}
}
