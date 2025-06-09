package com.example.module.product;

import java.util.List;

public interface ProductDao{
	
	public int selectOneCount(ProductVo Vo);
	public List<ProductDto> selectList(ProductVo vo);
	public ProductDto selectOne(ProductDto productDto);
	public ProductDto selectOne(ProductVo productVo);
	
	public int insert(ProductDto productDto);
	public int update(ProductDto productDto);
	public int delete(ProductDto productDto);
	public int uelete(ProductDto productDto);
	
	public List<ProductDto> selectListProduct();
	public int selectListWithoutPaging(ProductVo productVo);
	
	public int ueleteProductImage(ProductDto productDto);
	public int ueleteBackgroundImage(ProductDto productDto);
	
	public List<ProductDto> selectListWithImages(ProductVo vo);
}
