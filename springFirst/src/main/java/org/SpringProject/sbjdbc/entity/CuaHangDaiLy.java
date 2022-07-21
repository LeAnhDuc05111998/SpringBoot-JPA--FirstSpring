package org.SpringProject.sbjdbc.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "store")
@JsonIgnoreProperties
public class CuaHangDaiLy {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_cua_hang")
	private Long idCuaHang;
	
	@Column(name= "ten_cua_hang")
	private String tenCuaHang;
	
	@Column(name= "nguoi_quan_ly")
	private String quanLy;
	
	@Column(name= "ngay_khai_truong")
	private LocalDate ngayKhaiTruong;
	
	@Column(name= "uu_dai")
	private String chuongTrinhUuDai;
	
	@OneToOne(mappedBy = "cuaHangDaiLy")
    private Location location;
	
//	@OneToMany(mappedBy = "cuaHang", cascade = CascadeType.ALL)
//	private List<NhanVien> listnhanVien;
	
	public CuaHangDaiLy(){
		
	}	
	public CuaHangDaiLy(String tenCuaHang, String quanLy, LocalDate ngayKhaiTruong, String chuongTrinhUuDai) {
		super();
		this.tenCuaHang = tenCuaHang;
		this.quanLy = quanLy;
		this.ngayKhaiTruong = ngayKhaiTruong;
		this.chuongTrinhUuDai = chuongTrinhUuDai;
		
	}
	public Long getIdCuaHang() {
		return idCuaHang;
	}
	public void setIdCuaHang(Long idCuaHang) {
		this.idCuaHang = idCuaHang;
	}
	public String getTenCuaHang() {
		return tenCuaHang;
	}
	public void setTenCuaHang(String tenCuaHang) {
		this.tenCuaHang = tenCuaHang;
	}
	public String getQuanLy() {
		return quanLy;
	}
	public void setQuanLy(String quanLy) {
		this.quanLy = quanLy;
	}
	public LocalDate getNgayKhaiTruong() {
		return ngayKhaiTruong;
	}
	public void setNgayKhaiTruong(LocalDate ngayKhaiTruong) {
		this.ngayKhaiTruong = ngayKhaiTruong;
	}
	public String getChuongTrinhUuDai() {
		return chuongTrinhUuDai;
	}
	public void setChuongTrinhUuDai(String chuongTrinhUuDai) {
		this.chuongTrinhUuDai = chuongTrinhUuDai;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

}
