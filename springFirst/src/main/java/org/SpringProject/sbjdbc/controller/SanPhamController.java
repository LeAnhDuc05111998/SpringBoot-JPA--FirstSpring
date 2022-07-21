package org.SpringProject.sbjdbc.controller;

import java.util.Map;

import org.SpringProject.sbjdbc.entity.SanPham;
import org.SpringProject.sbjdbc.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sp")
public class SanPhamController {

	@Autowired
	private SanPhamService SanPhamService;

	@PostMapping("/")
	public Map<String, Object> saveSanPham(@RequestBody SanPham SanPham) {
		return SanPhamService.saveSanPham(SanPham);
	};

	@GetMapping("/")
	public Map<String, Object> getAllSanPham(@RequestParam(required = false) String searchString, 
			@RequestParam(required = false) String sortData, @RequestParam(required = false) Integer pageSize, @RequestParam(required = false) Integer page) {
		return SanPhamService.getAllSanPham(searchString, page, pageSize,sortData);
	};

	@GetMapping("/{id}")
	public Map<String, Object> getSanPhamById(@PathVariable Long id) {
		return SanPhamService.getSanPhamById(id);
	};

	@PutMapping("/{id}")
	public Map<String, Object> updateSanPham(SanPham SanPham) {
		return SanPhamService.updateSanPham(SanPham);
	};

	@DeleteMapping("/{id}")
	public Map<String, Object> deleteSanPham(@PathVariable Long id) {
		return SanPhamService.deleteSanPham(id);
	};
}
