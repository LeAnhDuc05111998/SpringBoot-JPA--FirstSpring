package org.SpringProject.sbjdbc.excel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.SpringProject.sbjdbc.entity.ChiTietNhapHang;

public class ExcelExport {
   private XSSFWorkbook workbook;
   private List<ChiTietNhapHang> listCTNH;
   public ExcelExport(List<ChiTietNhapHang> listCTNH) {
		this.listCTNH=listCTNH;
		workbook = new XSSFWorkbook();
   }
   private void createCell(Row row,int columnCount, Object value,CellStyle style) {
	      Cell cell=row.createCell(columnCount);
	      if(value instanceof Long) {
	    	    cell.setCellValue((Long) value);
	      }else if(value instanceof Integer) {
				cell.setCellValue((Integer) value);
		  }else if(value instanceof Boolean) {
				cell.setCellValue((Boolean) value);
		  }else if(value instanceof BigDecimal){		   
			    cell.setCellValue(((BigDecimal) value).doubleValue());
		  }else if(value instanceof LocalDate){
			    cell.setCellValue((LocalDate) value);
		  }else{
			    cell.setCellValue((String) value);
		  }
			    cell.setCellStyle(style);      
   }
    public void generate(HttpServletResponse response) throws IOException {
    	readerExcel();
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
    public void readerExcel() {	
       final String wordFilePath =("templates\\ChiTietNhapHang_Template.xlsx");
 	   try(BufferedInputStream inputStream = new BufferedInputStream(new ClassPathResource(wordFilePath).getInputStream())){
 	   Workbook wb = new XSSFWorkbook(inputStream);
 	   Sheet sheet = wb.getSheetAt(0);
 	   int Lastnum = sheet.getLastRowNum();
 	   for(int i = 0;i<=5;i++) {
 		  Row rowTotal = sheet.createRow(++Lastnum);
 		  rowTotal.createCell(i);
 		  CellStyle style=wb.createCellStyle();
 		  int rowCount=2;
 			for(ChiTietNhapHang detail:listCTNH) {
 				int columnCount=0;
 				sheet.autoSizeColumn(columnCount);
 				Row row=sheet.createRow(rowCount++);
 				createCell(row, columnCount++, detail.getIdDetail(), style);
 				createCell(row, columnCount++, detail.getIdUser(), style);
 				createCell(row, columnCount++, detail.getIdSanPham(), style);
 				createCell(row, columnCount++, detail.getSoLuong(), style);
 				createCell(row, columnCount++, detail.getTongTien(), style);
 				createCell(row, columnCount++, detail.getThoiGianNhap(), style);
 			}
 	   }
 	   inputStream.close();
 	   BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("src\\main\\resources\\templates\\ChiTietNhapHang_info.xlsx"));
 	   wb.write(outputStream);
 	   outputStream.flush();
 	   outputStream.close();
 	   }catch(Exception e) {
 		   e.printStackTrace();
 	   }
    }
}
   
 
