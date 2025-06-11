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
	
	public List<ProductDto> selectOneList(ProductDto productDto) {
		return productDao.selectOneList(productDto);
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
	
	public int update(ProductDto productDto) throws Exception {
	    
	    // 1. 상품의 텍스트 정보부터 업데이트합니다.
	    productDao.update(productDto);
	    
	    // 2. 사용자가 새로운 파일을 업로드했는지 확인
	    if (productDto.getUploadImg1() != null && productDto.getUploadImg1().length > 0 && !productDto.getUploadImg1()[0].isEmpty()) {
	        
	        // 3. uelete 쿼리에 pseq 값을 전달하기 위해 값을 설정
	        productDto.setPseq(productDto.getPrdtSeq());
	        
	        // 4. 기존 파일 정보 삭제
	        filesUploadDao.uelete(productDto);
	    
	        // 5. 새 파일 업로드
	        uploadFilesToS3(
	            productDto.getUploadImg1(),
	            productDto,
	            "infrBannerUploaded", 
	            productDto.getUploadImg1Type(),
	            productDto.getUploadImg1MaxNumber(),
	            productDto.getPrdtSeq(),
	            filesUploadDao,
	            amazonS3Client
	        );
	    }
	    
	    // 6. 모든 로직이 끝난 후, 메서드의 가장 마지막에서 return 합니다.
	    return 1;
	}
}
