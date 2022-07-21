package org.SpringProject.sbjdbc.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.SpringProject.sbjdbc.entity.ChiTietNhapHang;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import com.lowagie.text.DocumentException;

public class WordExport {
	XWPFDocument document;
	private List<ChiTietNhapHang> listCTNH;
	public WordExport(List<ChiTietNhapHang> listCTNH) {
        this.listCTNH = listCTNH;
     }
	   private void writeTableData(XWPFTable table) {
	        for (ChiTietNhapHang chiTietNhapHang :listCTNH) {
	        	XWPFTableRow row = table.createRow(); 
	        	row.getCell(0).setText(String.valueOf(chiTietNhapHang.getIdDetail()));
	        	row.getCell(1).setText(String.valueOf(chiTietNhapHang.getIdUser()));
	        	row.getCell(2).setText(String.valueOf(chiTietNhapHang.getIdSanPham()));
	        	row.getCell(3).setText(String.valueOf(chiTietNhapHang.getSoLuong()));
	        	row.getCell(4).setText(String.valueOf(chiTietNhapHang.getTongTien()));
	        	row.getCell(5).setText(String.valueOf(chiTietNhapHang.getThoiGianNhap()));
	         }
	   }
	   public void export(HttpServletResponse response) throws DocumentException, IOException, InvalidFormatException { 
		    readerWordTemplate();
		    ServletOutputStream outputStream = response.getOutputStream();
	        outputStream.close();
	   }
	   public void readerWordTemplate() throws IOException {
			final String wordFilePath = "C:\\Users\\ducla\\eclipse-workspace\\springFirst\\src\\main\\resources\\templates\\ChiTietNhapHang_info.docx";
			FileInputStream input = new FileInputStream(new File(wordFilePath));
			XWPFDocument document = new XWPFDocument(input);
			XWPFParagraph paragraph = document.createParagraph(); 
            XWPFRun run = paragraph.createRun();
            run.setBold(true);
			XWPFTable table = document.createTable();
			XWPFTableRow row = table.getRow(0);
			  row.getCell(0).setText("idDetail");
              row.addNewTableCell().setText("idUser");
              row.addNewTableCell().setText("idSanPham");
              row.addNewTableCell().setText("soLuong");
              row.addNewTableCell().setText("tongTien");
              row.addNewTableCell().setText("thoiGianNhap");
            writeTableData(table);
            input.close();
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\ducla\\eclipse-workspace\\springFirst\\src\\main\\resources\\templates\\ChiTietNhapHang_info - Copy.docx");
  			document.write(outputStream);
	        document.close();
	        outputStream.close();
	   }
}
