package com.example.module.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.example.common.base.BaseService;

@Service
public class ProductService extends BaseService {
	@Autowired
	ProductDao productDao;
	
	@Autowired
	private AmazonS3Client amazonS3Client;
	
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
	
	public void insertProductImages(ProductDto dto) throws Exception {
			
			if (dto.getBackgroundInput() != null && dto.getBackgroundInput().toString().isEmpty()) {
				productDao.ueleteBackgroundImage(dto);
				dto.setUploadImg1(dto.getBackgroundInput());
				dto.setUploadImg1Type(11);
				dto.setUploadImg1MaxNumber(11);
				uploadFilesToS3(dto.getUploadImg1(), dto, "image", dto.getUploadImg1Type(), dto.getUploadImg1MaxNumber()
						, dto.getPrdtSeq(), productDao, amazonS3Client);
			}
			if (dto.getProfileInput() != null && dto.getProfileInput().toString().isEmpty()) {
				productDao.ueleteProductImage(dto);
				dto.setUploadImg1(dto.getProfileInput());
				dto.setUploadImg1Type(12);
				dto.setUploadImg1MaxNumber(12);
				uploadFilesToS3(dto.getUploadImg1(), dto, "image", dto.getUploadImg1Type(), dto.getUploadImg1MaxNumber()
						, dto.getPrdtSeq(), productDao, amazonS3Client);
			}
		}
}
