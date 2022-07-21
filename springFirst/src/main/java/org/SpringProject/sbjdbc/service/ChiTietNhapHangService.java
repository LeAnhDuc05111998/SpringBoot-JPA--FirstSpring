package org.SpringProject.sbjdbc.service;

import java.util.Map;

import org.SpringProject.sbjdbc.dto.ChiTietNhapHangDto;
import org.SpringProject.sbjdbc.entity.ChiTietNhapHang;

public interface ChiTietNhapHangService {

	Map<String, Object> saveChiTietNhapHang(ChiTietNhapHangDto ChiTietNhapHang);
	
	Map<String, Object> getAllChiTietNhapHang(String search, Integer page, Integer pageSize);

	Map<String, Object> getChiTietNhapHangById(Long id);

	Map<String, Object> updateChiTietNhapHang(ChiTietNhapHang ChiTietNhapHang);

}
