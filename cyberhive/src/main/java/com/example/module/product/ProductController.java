package com.example.module.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.common.base.BaseController;
import com.example.module.filesupload.FilesUploadDto;
import com.example.module.filesupload.FilesUploadService;


@Controller
public class ProductController extends BaseController {

	@Autowired
	ProductService productService;
	
	@Autowired
    FilesUploadService filesUploadService;
	
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
	public String productXdmForm(@ModelAttribute("item") ProductDto dto, Model model) throws Exception {
			
		if (dto.getPrdtSeq() != null && !dto.getPrdtSeq().isEmpty() && !dto.getPrdtSeq().equals("0")) {
	        ProductDto item = productService.selectOne(dto);
	        model.addAttribute("item", item);
	        
	        FilesUploadDto filesUploadDto = new FilesUploadDto();
	        filesUploadDto.setPseq(item.getPrdtSeq());
	        FilesUploadDto itemFile = filesUploadService.selectOne(filesUploadDto);
	        
	        if (itemFile != null) {
	            model.addAttribute("itemFile", itemFile);
	        } else {
	            model.addAttribute("itemFile", new FilesUploadDto());
	        }
	    } else {
	        // 수정 모드
	    	model.addAttribute("itemFile", new FilesUploadDto());
	    }
	    
	    return "xdm/product/ProductXdmForm";
	}
	
	@RequestMapping(value = "/xdm/product/ProductXdmView")
	public String productXdmView(Model model, ProductDto productDto) {
//		System.out.println("전달할 데이터: " + productService.selectOne(productDto));
		model.addAttribute("item", productService.selectOne(productDto));
//		model.addAttribute("list", productService.selectOneList(productDto));
		return "xdm/product/ProductXdmView";
	}
	
	@RequestMapping(value = "/xdm/product/ProductXdmUpdt")
	public String productXdmUpdt(ProductDto productDto) throws Exception {
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
		productService.insert(productDto);
		
		return "redirect:/xdm/product/ProductXdmList";
	}
	
}

