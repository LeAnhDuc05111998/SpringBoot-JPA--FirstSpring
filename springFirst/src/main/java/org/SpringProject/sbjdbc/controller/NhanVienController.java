package org.SpringProject.sbjdbc.controller;

import java.util.Map;

import org.SpringProject.sbjdbc.entity.NhanVien;
import org.SpringProject.sbjdbc.service.NhanVienService;
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
@RequestMapping("/api/nhanvien")
public class NhanVienController {
    @Autowired
	NhanVienService nhanVienService;
    
    @PostMapping("/")
    public Map<String,Object> saveNhanVien (@RequestBody NhanVien nhanVien){    	
		return nhanVienService.saveNhanVien(nhanVien); 	
    }
    @GetMapping("/")
    public Map<String,Object> getAllNhanVien (){
    	return nhanVienService.getAllNhanVien();
    }
    @GetMapping("/{idNhanVien}")
    public Map<String,Object> getNhanVienById (@PathVariable NhanVien nhanVien) {
		return nhanVienService.getNhanVienById(nhanVien);	
    }
    @PutMapping("/{idNhanVien}")
    public Map<String,Object> updateNhanVien (NhanVien nhanVien){
		return nhanVienService.updateNhanVien(nhanVien);    	
    }
    @DeleteMapping("/{idNhanVien}")
    public Map<String,Object> deleteNhanVien (@PathVariable Long idNhanVien){
		return nhanVienService.deleteNhanVien(idNhanVien);  	
    }
}
