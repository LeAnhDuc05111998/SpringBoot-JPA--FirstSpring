package org.SpringProject.sbjdbc.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.SpringProject.sbjdbc.entity.SanPham;
import lombok.Data;

@Data
public class SanPhamNhapDto {

	private SanPham sanPham;

	private BigDecimal soLuong;

	private BigDecimal tongTien;
	
	private LocalDate thoiGianNhap;
	
}
