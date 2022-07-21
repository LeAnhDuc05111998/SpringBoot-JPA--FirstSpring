package org.SpringProject.sbjdbc.entity;

import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "nhanvien")
@JsonIgnoreProperties({"location"})
public class NhanVien {
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   @Column(name= "id")
   private long idNhanVien;
   @Column(name= "ten_nv")
   private String tenNhanVien;
   @Column(name= "gio_lam")
   private LocalTime gioLamViec;
   @Column(name= "salary")
   private Long luong;
   @Column(name= "thanh_tich")
   private String thanhTich;
   @ManyToOne()
   @JoinColumn(name="id_store",foreignKey = @ForeignKey(name = "store_fk"))
   private CuaHangDaiLy cuaHang;

   public NhanVien() {
      
   }

public NhanVien(String tenNhanVien, LocalTime gioLamViec, Long luong, String thanhTich, CuaHangDaiLy cuaHang) {
		super();
		this.tenNhanVien = tenNhanVien;
		this.gioLamViec = gioLamViec;
		this.luong = luong;
		this.thanhTich = thanhTich;
	    this.cuaHang = cuaHang;
 }

public long getIdNhanVien() {
	return idNhanVien;
}

public void setIdNhanVien(long idNhanVien) {
	this.idNhanVien = idNhanVien;
}

public String getTenNhanVien() {
	return tenNhanVien;
}

public void setTenNhanVien(String tenNhanVien) {
	this.tenNhanVien = tenNhanVien;
}

public LocalTime getGioLamViec() {
	return gioLamViec;
}

public void setGioLamViec(LocalTime gioLamViec) {
	this.gioLamViec = gioLamViec;
}

public Long getLuong() {
	return luong;
}

public void setLuong(Long luong) {
	this.luong = luong;
}

public String getThanhTich() {
	return thanhTich;
}

public void setThanhTich(String thanhTich) {
	this.thanhTich = thanhTich;
}

public CuaHangDaiLy getCuaHangDaiLy() {
	return cuaHang;
}

public void setCuaHangDaiLy(CuaHangDaiLy cuaHangDaiLy) {
	this.cuaHang = cuaHangDaiLy;
}
 
}

