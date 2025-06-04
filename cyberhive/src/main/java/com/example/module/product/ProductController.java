package com.example.module.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
	public String productXdmForm(@ModelAttribute("vo") ProductVo vo, ProductDto productDto, FilesUploadDto filesUploadDto, Model model) throws Exception {
			
			if (vo.getSeq().equals("0") || vo.getSeq().equals("")) {
	//			insert mode
			} else {
	//			update mode
				filesUploadDto.setPseq(productDto.getSeq());
				FilesUploadDto dto = filesUploadService.selectOne(filesUploadDto);
				System.out.println(dto.getPath());
				
				model.addAttribute("item", productService.selectOne(productDto));
				model.addAttribute("itemFile", dto);
			}
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
		productService.insert(productDto);
		
		return "redirect:/xdm/product/ProductXdmList";
	}
	
}

