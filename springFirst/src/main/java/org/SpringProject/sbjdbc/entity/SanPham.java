package org.SpringProject.sbjdbc.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "sanpham")
@Data
public class SanPham {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "tensp")
	private String tenSP;

	@Column(name = "giasp")
	private BigDecimal gia;

	@Column(name = "nguongoc")
	private String nguonGoc;

	@Column(name = "ngaysx")
	private LocalDate ngaySX;

	@Column(name = "ngayhethan")
	private LocalDate ngayHetHan;
	
	@Column(name = "isdelete")
	private Boolean isDelete;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nhasxfkid", foreignKey = @ForeignKey(name = "nhasx_sp_fkid"))
	private NhaSanXuat nhaSX;
	
	//@ManyToMany(mappedBy = "sanpham")
	//private User user;
	
	public SanPham() {
		
	}
	public SanPham(String tenSP, BigDecimal gia, String nguonGoc, LocalDate ngaySX, LocalDate ngayHetHan,
			NhaSanXuat nhaSX) {
		super();
		this.tenSP = tenSP;
		this.gia = gia;
		this.nguonGoc = nguonGoc;
		this.ngaySX = ngaySX;
		this.ngayHetHan = ngayHetHan;
		this.nhaSX = nhaSX;
	}
	
}
