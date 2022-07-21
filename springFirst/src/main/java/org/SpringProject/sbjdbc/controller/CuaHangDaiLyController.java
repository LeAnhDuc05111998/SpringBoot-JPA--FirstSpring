package org.SpringProject.sbjdbc.controller;

import java.util.Map;
import org.SpringProject.sbjdbc.entity.CuaHangDaiLy;
import org.SpringProject.sbjdbc.service.CuaHangDaiLyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/store")
public class CuaHangDaiLyController {
    
	@Autowired
	CuaHangDaiLyService cuaHangDaiLyService;
	
	@PostMapping("/")
	public Map<String,Object> saveCuaHang ( @RequestBody CuaHangDaiLy cuaHangDaiLy) {
		return cuaHangDaiLyService.saveCuaHang(cuaHangDaiLy);
	}
	@GetMapping("/")
	public Map<String,Object> getAllCuaHang () {
		return cuaHangDaiLyService.getAllCuaHang();		
	}
	@GetMapping("/{idCuaHang}")
	Map<String,Object> getCuaHangById ( @PathVariable Long idCuaHang){
		return cuaHangDaiLyService.getCuaHangById(idCuaHang);	
	}
	@PutMapping("/{idCuaHang}")
	Map<String,Object> updateCuaHang (CuaHangDaiLy cuaHangDaiLy){
		return cuaHangDaiLyService.updateCuaHang(cuaHangDaiLy);		
	}
	@DeleteMapping("/{idCuaHang}")
	Map<String,Object> xoaCuaHang ( @PathVariable Long idCuaHang){
		return cuaHangDaiLyService.xoaCuaHang(idCuaHang);		
	}
}
