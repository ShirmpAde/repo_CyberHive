package com.example.module.grid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.module.product.ProductDto;
import com.example.module.product.ProductService;
import com.example.module.product.ProductVo;

@Controller
public class GridController {
	
	@Autowired
	GridService gridService;
	
	@Autowired
    private ProductService productService;
	
	@RequestMapping(value = "/user/grid/GridUserForm")
	public String gridUserForm(Model model, ProductVo vo) throws Exception {
	    List<ProductDto> list = productService.selectListWithImages(vo);
	    model.addAttribute("products", list);		
		return "user/grid/GridUserForm";
	}
}
