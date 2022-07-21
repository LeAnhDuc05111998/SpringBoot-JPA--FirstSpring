package org.SpringProject.sbjdbc.repository;

import org.SpringProject.sbjdbc.entity.ChiTietNhapHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChiTietNhapHangRepository extends JpaRepository<ChiTietNhapHang, Long> {

	ChiTietNhapHang findByIdUserAndIdSanPham(Long idUser, Long idSanPham);
	
}
