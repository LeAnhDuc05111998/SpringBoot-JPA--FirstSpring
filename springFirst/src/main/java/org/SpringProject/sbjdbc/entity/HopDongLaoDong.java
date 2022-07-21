package org.SpringProject.sbjdbc.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ct_contract")
@Data
public class HopDongLaoDong {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContract;
	
	@Column(name="id_nv")
	 private long idNhanVien;
	
	@Column(name="id_store")
	private Long idCuaHang;
	
	@Column(name="luong_start")
	private Long luongKhoiDiem;
	
	@Column(name="up_luong")
	private Long luongTangTheoThang;
	
	@Column(name="bonus_luong")
	private String thuongDoanhThu;
	
	@Column(name="num_phep")
    private Integer soNgayPhep;
    
    @Column(name="expired")
    private LocalDate ngayHetHan;

}
