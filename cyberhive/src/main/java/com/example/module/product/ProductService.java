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
			, productDto.getPrdtSeq()
			, filesUploadDao
			, amazonS3Client);
	return 1;
	}
	
	public List<ProductDto> selectListWithImages(ProductVo vo) throws Exception {
        // DAO(Mapper)에 있는 동일한 이름의 메서드를 호출하여 DB 결과를 반환합니다.
        return productDao.selectListWithImages(vo); 
    }

}
