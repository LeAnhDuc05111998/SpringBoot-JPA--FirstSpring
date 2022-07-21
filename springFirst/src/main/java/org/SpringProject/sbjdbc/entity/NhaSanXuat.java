package org.SpringProject.sbjdbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "nhasx")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NhaSanXuat {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "tennsx")
    private String tenNhaSX;
	
	@Column(name = "diachi")
    private String diaChi;
	
	@Column(name = "sodt")
    private String soDT;
	
	@Column(name = "isdelete")
	private Boolean isDelete;

}
