package org.SpringProject.sbjdbc.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ct_hoptac")
@Data
public class ChiTietHopTac implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHopTac;
	
	@ManyToOne
	@JoinColumn(name="idCuaHang")
    private CuaHangDaiLy cuaHangDaiLy;
    
	@ManyToOne
	@JoinColumn(name="id_nsx")
    private NhaSanXuat nhaSanXuat;
	
	@Column(name="ngay_start")
	private LocalDate ngayBatDau;
	
	@Column(name="month")
	private Integer soThang;	

}
