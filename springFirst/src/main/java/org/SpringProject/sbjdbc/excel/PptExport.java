package org.SpringProject.sbjdbc.excel;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.SpringProject.sbjdbc.entity.ChiTietNhapHang;
import org.apache.poi.sl.usermodel.TextParagraph.TextAlign;
import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTable;
import org.apache.poi.xslf.usermodel.XSLFTableCell;
import org.apache.poi.xslf.usermodel.XSLFTableRow;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import com.lowagie.text.DocumentException;

public class PptExport {
	private List<ChiTietNhapHang> listCTNH;
	public PptExport(List<ChiTietNhapHang> listCTNH) {
		this.listCTNH = listCTNH;
	}
	  private void writeTableHeader(XSLFTable table) {
			    XSLFTableRow headerRow = table.addRow();
		        XSLFTableCell th = headerRow.addCell();
		        XSLFTableCell th1 = headerRow.addCell();
		        XSLFTableCell th2 = headerRow.addCell();
		        XSLFTableCell th3 = headerRow.addCell();
		        XSLFTableCell th4 = headerRow.addCell();
		        XSLFTableCell th5 = headerRow.addCell();
		        XSLFTextParagraph p = th.addNewTextParagraph();
		        p.setTextAlign(TextAlign.LEFT);
		        if(th!=null){
				       th.setText("idDetail");
				       th1.setText("idUser");
				       th2.setText("idSanPham");
				       th3.setText("soLuong");
				       th4.setText("tongTien");
				       th5.setText("thoiGianNhap");
				}       
	  }
	  private void writeTableData(XSLFTable table) { 
		  for (ChiTietNhapHang chiTietNhapHang :listCTNH) {
			         XSLFTableRow bodyRow = table.addRow();
		             XSLFTableCell th = bodyRow.addCell();
		             XSLFTableCell th1 = bodyRow.addCell();
		             XSLFTableCell th2 = bodyRow.addCell();
		             XSLFTableCell th3 = bodyRow.addCell();
		             XSLFTableCell th4 = bodyRow.addCell();
		             XSLFTableCell th5 = bodyRow.addCell();
		             if(bodyRow!=null){
				        th.setText(String.valueOf(chiTietNhapHang.getIdDetail()));
				        th1.setText(String.valueOf(chiTietNhapHang.getIdUser()));
				        th2.setText(String.valueOf(chiTietNhapHang.getIdSanPham()));
				        th3.setText(String.valueOf(chiTietNhapHang.getSoLuong()));
				        th4.setText(String.valueOf(chiTietNhapHang.getTongTien()));
				        th5.setText(String.valueOf(chiTietNhapHang.getThoiGianNhap()));
				}       
	       }
	  }
	  
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		
		XMLSlideShow document = new XMLSlideShow();
	    XSLFSlideMaster slideMaster = document.getSlideMasters().get(0);
	    XSLFSlideLayout titleLayout = slideMaster.getLayout(SlideLayout.TITLE);
	    XSLFSlide slide = document.createSlide(titleLayout);
	    XSLFSlide slide1 = document.createSlide();
	    XSLFTextShape title = slide.getPlaceholder(0);
	    title.setText("ChiTietNhapHang"); 
		XSLFTable table = slide1.createTable();
	    table.setAnchor(new Rectangle(50, 100, 800, 800));
		ServletOutputStream outputStream = response.getOutputStream();
		writeTableHeader(table);
		writeTableData(table);
		document.write(outputStream); 
		document.close();
	}
}
