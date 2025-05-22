package com.example.module.code;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.common.base.BaseController;
import com.example.common.util.UtilDateTime;
import com.example.module.codegroup.CodeGroupService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CodeController extends BaseController {
	
	@Autowired
	CodeService codeService;
	
	@Autowired
	CodeGroupService codeGroupService;
	
	@RequestMapping(value = "/code/codeXdmList")
	public String codeXdmList(CodeVo vo, Model model) throws Exception{
		
		utildatetime(vo);
		
		vo.setParamsPaging(codeService.selectOneCount(vo));
		
		model.addAttribute("list", codeService.selectList(vo));
		model.addAttribute("vo", vo);
		
		return "xdm/code/CodeXdmList";
	}
	
	@RequestMapping(value = "/code/codeXdmForm")
	public String codeXdmForm(@ModelAttribute("vo") CodeVo vo, Model model) {
//		model.addAttribute("list", codeService.selectGroupList());
		model.addAttribute("list", codeGroupService.selectListWithoutPaging());
		
		if (vo.getCodeSeq().equals("0") || vo.getCodeSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", codeService.selectOne(vo));
		}
		
		return "xdm/code/CodeXdmForm";
	}
	
	@RequestMapping(value = "/code/codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
		codeService.insert(codeDto);
		return "redirect:/code/codeXdmList";
	}
	
	@RequestMapping(value = "/code/codeXdmMfom")
	public String codeXdmMfom(Model model, CodeDto codeDto) {
//		model.addAttribute("list", codeService.selectGroupList());
		model.addAttribute("list", codeGroupService.selectListWithoutPaging());
		model.addAttribute("item", codeService.selectOne(codeDto));
		return "xdm/code/CodeXdmMfom";
	}
	
	@RequestMapping(value = "/code/codeXdmUpdt")
	public String codeXdmUpdt(CodeDto codeDto) {
		codeService.update(codeDto);
		return "redirect:/code/codeXdmList";
	}
	
	@RequestMapping(value = "/code/codeXdmDele")
	public String codeXdmDele(CodeDto codeDto) {
		codeService.delete(codeDto);
		return "redirect:xdm/code/codeXdmList";
	}
	
	@RequestMapping(value = "/code/codeXdmUele")
	public String codeXdmUele(CodeDto codeDto) {
		codeService.uelete(codeDto);
		return "redirect:/code/codeXdmList";
	}
	
	@RequestMapping("/code/excelDownload")
    public void excelDownload(CodeVo vo, HttpServletResponse httpServletResponse) throws Exception {
		
		setSearch(vo);
		vo.setParamsPaging(codeService.selectOneCount(vo));

		if (vo.getTotalRows() > 0) {
			List<CodeDto> list = codeService.selectList(vo);
			
//			Workbook workbook = new HSSFWorkbook();	// for xls
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("첫번째 시트");
	        CellStyle cellStyle = workbook.createCellStyle();        
	        Row row = null;
	        Cell cell = null;
	        int rowNum = 0;
			
//	        each column width setting
	        sheet.setColumnWidth(0, 2100);
	        sheet.setColumnWidth(1, 3100);

//	        Header
	        String[] tableHeader = {"코드그룹 코드", "코드그룹 이름", "코드", "코드 이름", "사용", "등록일", "수정일"};

	        row = sheet.createRow(rowNum++);
			for(int i=0; i<tableHeader.length; i++) {
				cell = row.createCell(i);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
				cell.setCellValue(tableHeader[i]);
			}

//	        Body
	        for (int i=0; i<list.size(); i++) {
	            row = sheet.createRow(rowNum++);
	            
//	            String type: null 전달 되어도 ok
//	            int, date type: null 시 오류 발생 하므로 null check
//	            String type 이지만 정수형 데이터가 전체인 seq 의 경우 캐스팅
	            
	            cell = row.createCell(0);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	            cell.setCellValue(Integer.parseInt(list.get(i).getCdgrSeq()));
	            
	            cell = row.createCell(1);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getCdgrName());
	        	
	            cell = row.createCell(2);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(Integer.parseInt(list.get(i).getCodeSeq()));
	        	
	            cell = row.createCell(4);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            cell.setCellValue(list.get(i).getCodeName());
	            
	            cell = row.createCell(6);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            if(list.get(i).getCodeUseNy() != null) cell.setCellValue(list.get(i).getCodeUseNy() == 0 ? "N" : "Y");
	            
	            cell = row.createCell(8);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	if(list.get(i).getCodeRegDate() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getCodeRegDate()));
	        	
	        	cell = row.createCell(9);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	if(list.get(i).getCodeModDate() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getCodeModDate()));
	        }

	        httpServletResponse.setContentType("ms-vnd/excel");
//	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xls");	// for xls
	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xlsx");

	        workbook.write(httpServletResponse.getOutputStream());
	        workbook.close();
		}
    }
}


