package org.SpringProject.sbjdbc.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "dia_diem")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Location implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idDiaDiem;
	@Column(name= "so_hieu")
	private String soHieuDaiLy;
	@Column(name= "street")
	private String street;
	@Column(name= "city")
	private String city;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_cuahang")
    @JsonIgnore
    private CuaHangDaiLy cuaHangDaiLy;
	
	public Location() {
		
	}	
	public Location(String soHieuDaiLy, String street, String city) {
		super();
		this.soHieuDaiLy = soHieuDaiLy;
		this.street = street;
		this.city = city;
	}

	public Long getIdDiaDiem() {
		return idDiaDiem;
	}

	public void setIdDiaDiem(Long idDiaDiem) {
		this.idDiaDiem = idDiaDiem;
	}

	public String getSoHieuDaiLy() {
		return soHieuDaiLy;
	}

	public void setSoHieuDaiLy(String soHieuDaiLy) {
		this.soHieuDaiLy = soHieuDaiLy;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public CuaHangDaiLy getCuaHangDaiLy() {
		return cuaHangDaiLy;
	}
	
	public void setCuaHangDaiLy(CuaHangDaiLy cuaHangDaiLy) {
		this.cuaHangDaiLy = cuaHangDaiLy;
	}
	
}
