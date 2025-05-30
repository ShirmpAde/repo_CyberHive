package com.example.module.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.common.base.BaseController;


@Controller
public class ProductController extends BaseController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/xdm/product/ProductXdmList")
	public String productXdmList(Model model, @ModelAttribute("vo") ProductVo vo) {
		utildatetime(vo);
		
		vo.setParamsPaging(productService.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
		model.addAttribute("list", productService.selectList(vo));
		}
		return "xdm/product/ProductXdmList";
	}
	
	@RequestMapping(value = "/xdm/product/ProductXdmForm")
	public String productXdmForm(@ModelAttribute("vo") ProductVo vo, Model model) throws Exception{
		return "xdm/product/ProductXdmForm";
	}
	
	@RequestMapping(value = "/xdm/product/ProductXdmUpdt")
	public String productXdmUpdt(ProductDto productDto) {
		System.out.println("[INFO] ProductXdmUpdt 호출됨 - DTO: " + productDto);
		productService.update(productDto);
		
		return "redirect:/xdm/product/ProductXdmList";
	}
	
	@RequestMapping(value = "/xdm/product/ProductXdmDele")
	public String productXdmDele(ProductDto productDto) {
		System.out.println("[INFO] ProductXdmDele 호출됨 - DTO: " + productDto);
		productService.delete(productDto);
		
		return "redirect:/xdm/product/ProductXdmList";
	}
	
	@RequestMapping(value = "/xdm/product/ProductXdmUele")
	public String productXdmUele(ProductDto productDto) {
		System.out.println("[INFO] ProductXdmUele 호출됨 - DTO: " + productDto);
		productService.uelete(productDto);
		
		return "redirect:/xdm/product/ProductXdmList";
	}
	
	@RequestMapping(value = "/xdm/product/ProductXdmInst")
	public String productXdmInst(ProductDto productDto) throws Exception {
		System.out.println("[INFO] ProductXdmInst 호출됨 - DTO: " + productDto);
		System.out.println("[DATA] " + productDto.toString()); 
	    
		if (productDto.getUploadImg1() != null) {
	        System.out.println("[FILE] 업로드 파일 개수: " + productDto.getUploadImg1().length);
	        for (MultipartFile file : productDto.getUploadImg1()) {
	            System.out.println("[FILE] " + file.getOriginalFilename() + " (" + file.getSize() + " bytes)");
	        }
	    }
		
		System.out.println("[SUCCESS] 상품 등록 완료 - 생성된 seq: " + productDto.getPrdtSeq());
		
	    return "redirect:/xdm/product/ProductXdmList";
	}
	
	@ResponseBody
	@RequestMapping(value = "/xdm/product/ProductImageProc")
	public String ProductImageProc(ProductDto dto) throws Exception {
		productService.insertProductImages(dto);

		return "redirect:\"/xdm/product/ProductXdmList";
	}
}

