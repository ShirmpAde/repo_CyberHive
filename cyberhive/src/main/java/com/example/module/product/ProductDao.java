package com.example.module.product;

import java.util.List;

import com.example.common.base.BaseDao;

public interface ProductDao extends BaseDao{
	
	public int selectOneCount();
	public List<ProductDto> selectList(ProductVo vo);
	public ProductDto selectOne(ProductDto productDto);
	public ProductDto selectOne(ProductVo productVo);
	public int insert(ProductDto productDto);
	public int update(ProductDto productDto);
	public int delete(ProductDto productDto);
	public int uelete(ProductDto productDto);
	public int selectListWithoutPaging(ProductVo productVo);
}
