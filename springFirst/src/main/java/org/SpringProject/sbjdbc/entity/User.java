package org.SpringProject.sbjdbc.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "nguoidung")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "hoten")
	private String hoTen;

	@Column(name = "diachi")
	private String diaChi;

	@Column(name = "sodt")
	private String soDT;

	@Column(name = "ngaysinh")
	private LocalDate ngaySinh;

	@Column(name = "gioitinh")
	private String gioiTinh;
	
	@Column(name = "isdelete")
	private Boolean isDelete;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Address address;
	
	public User() {
		
	}
	public User(String hoTen, String diaChi, String soDT, LocalDate ngaySinh, String gioiTinh) {
		super();
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
	}	
}
