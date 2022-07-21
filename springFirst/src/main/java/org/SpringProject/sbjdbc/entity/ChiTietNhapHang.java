package org.SpringProject.sbjdbc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name = "ct_nhaphang")
@Data
public class ChiTietNhapHang implements Serializable {
	
 /**
	 * 
	 */
   private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "iddetail")
private Long idDetail;
	
@Column(name = "iduser")
private Long idUser;
 
@Column(name = "idsanpham")
private Long idSanPham;

@Column(name = "soluong")
private BigDecimal soLuong;

@Column(name = "tongtien")
private BigDecimal tongTien;

@Column(name="thoigiannhap",updatable = false)
@CreationTimestamp
private LocalDate thoiGianNhap;

}
