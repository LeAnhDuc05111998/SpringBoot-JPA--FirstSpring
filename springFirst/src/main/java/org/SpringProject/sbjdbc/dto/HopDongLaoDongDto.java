package org.SpringProject.sbjdbc.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
public class HopDongLaoDongDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private long idNhanVien;
    
	private Long idCuaHang;
	
	private Long luongKhoiDiem;
	
    private Integer soNgayPhep;
    
    private LocalDate ngayHetHan;
}
