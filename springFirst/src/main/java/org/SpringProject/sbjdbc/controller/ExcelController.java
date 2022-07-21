package org.SpringProject.sbjdbc.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.SpringProject.sbjdbc.entity.ChiTietNhapHang;
import org.SpringProject.sbjdbc.excel.ExcelExport;
import org.SpringProject.sbjdbc.excel.PdfExport;
import org.SpringProject.sbjdbc.excel.PptExport;
import org.SpringProject.sbjdbc.excel.WordExport;
import org.SpringProject.sbjdbc.repository.ChiTietNhapHangRepository;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lowagie.text.DocumentException;

@Controller
@RequestMapping("/excel")
public class ExcelController {
   @Autowired
   private ChiTietNhapHangRepository chiTietNhapHangRepository;
   
   @GetMapping("/export/excel")
   public void exportToExcel(HttpServletResponse response1) throws IOException {
		response1.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headervalue = "attachment; filename=ChiTietNhapHang_info.xlsx";
		response1.setHeader(headerKey, headervalue);
		response1.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
		List<ChiTietNhapHang> listCTNH = chiTietNhapHangRepository.findAll();
		ExcelExport exp = new ExcelExport(listCTNH);
		exp.generate(response1);
	}
    @GetMapping("/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");    
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ChiTietNhapHang_info.pdf";
        response.setHeader(headerKey, headerValue);      
        List<ChiTietNhapHang> listCTNH = chiTietNhapHangRepository.findAll();
        PdfExport exp = new PdfExport(listCTNH);
        exp.export(response);
         
    }
    @GetMapping("/export/word")
    public void exportToWord(HttpServletResponse response) throws DocumentException, IOException, InvalidFormatException {
        response.setContentType("application/docx");     
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ChiTietNhapHang_info.docx";
        response.setHeader(headerKey, headerValue);     
        List<ChiTietNhapHang> listCTNH = chiTietNhapHangRepository.findAll();         
        WordExport exp = new WordExport(listCTNH);
        exp.export(response);   
    }
    @GetMapping("/export/pptx")
    public void exportToPpt(HttpServletResponse response) throws DocumentException, IOException, InvalidFormatException {
        response.setContentType("application/pptx");     
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ChiTietNhapHang_info.pptx";
        response.setHeader(headerKey, headerValue);      
        List<ChiTietNhapHang> listCTNH = chiTietNhapHangRepository.findAll();         
        PptExport exp = new PptExport(listCTNH);
        exp.export(response);    
    }   
}
   