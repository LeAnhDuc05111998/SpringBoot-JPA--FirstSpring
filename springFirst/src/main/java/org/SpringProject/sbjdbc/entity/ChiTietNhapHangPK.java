package org.SpringProject.sbjdbc.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ChiTietNhapHangPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private Long idUser;
    
	private Long idSanPham;
}
