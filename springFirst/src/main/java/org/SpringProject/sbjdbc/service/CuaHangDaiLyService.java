package org.SpringProject.sbjdbc.service;

import java.util.Map;

import org.SpringProject.sbjdbc.entity.CuaHangDaiLy;

public interface CuaHangDaiLyService {
	Map<String,Object> saveCuaHang (CuaHangDaiLy cuaHangDaiLy);
	
	Map<String,Object> getAllCuaHang ();
	
	Map<String,Object> getCuaHangById (Long idCuaHang);
	
	Map<String,Object> updateCuaHang (CuaHangDaiLy cuaHangDaiLy);
	
	Map<String,Object> xoaCuaHang (Long idCuaHang);
}
