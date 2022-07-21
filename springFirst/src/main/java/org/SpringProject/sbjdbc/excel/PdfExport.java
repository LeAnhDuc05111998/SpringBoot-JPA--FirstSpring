package org.SpringProject.sbjdbc.excel;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.SpringProject.sbjdbc.entity.ChiTietNhapHang;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfExport {
	private List<ChiTietNhapHang> listCTNH;
	public PdfExport(List<ChiTietNhapHang> listCTNH) {
        this.listCTNH = listCTNH;
     }
	 private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(5);        
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	        cell.setPhrase(new Phrase("idDetail", font));
	         
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("idUser", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("idSanPham", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("soLuong", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("tongTien", font));
	        table.addCell(cell);
	       
	   }
	   private void writeTableData(PdfPTable table) {
			for (ChiTietNhapHang chiTietNhapHang : listCTNH) {
	            table.addCell(String.valueOf(chiTietNhapHang.getIdDetail()));
	            table.addCell(String.valueOf(chiTietNhapHang.getIdUser()));
	            table.addCell(String.valueOf(chiTietNhapHang.getIdSanPham()));
	            table.addCell(String.valueOf(chiTietNhapHang.getSoLuong()));
	            table.addCell(String.valueOf(chiTietNhapHang.getTongTien()));
	         }
	   }
	   public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document();
	        PdfWriter.getInstance(document, response.getOutputStream());         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.GREEN);	         
	        Paragraph p = new Paragraph("List of ChiTietNhapHang", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);	         
	        document.add(p);         
	        PdfPTable table = new PdfPTable(5);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
	        table.setSpacingBefore(10);	         
	        writeTableHeader(table);
	        writeTableData(table);	         
	        document.add(table);	         
	        document.close();
	         
	   }
}
