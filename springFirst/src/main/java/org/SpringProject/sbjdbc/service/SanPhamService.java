package org.SpringProject.sbjdbc.service;

import java.util.Map;

import org.SpringProject.sbjdbc.entity.SanPham;

public interface SanPhamService  {

	Map<String, Object> saveSanPham(SanPham sanPham);

	Map<String, Object> getAllSanPham(String search, Integer page, Integer pageSize, String sortData);

	Map<String, Object> getSanPhamById(Long id);

	Map<String, Object> updateSanPham(SanPham sanPham);

	Map<String, Object> deleteSanPham(Long id);
	
	

}
