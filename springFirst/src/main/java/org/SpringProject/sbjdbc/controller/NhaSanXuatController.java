package org.SpringProject.sbjdbc.controller;

import java.util.Map;

import org.SpringProject.sbjdbc.entity.NhaSanXuat;
import org.SpringProject.sbjdbc.service.NhaSanXuatService;
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
@RequestMapping("/api/nhasx")
public class NhaSanXuatController {
	@Autowired
	private NhaSanXuatService NhaSanXuatService;

	@PostMapping("/")
	public Map<String, Object> saveNhaSanXuat(@RequestBody NhaSanXuat NhaSanXuat) {
		return NhaSanXuatService.saveNhaSanXuat(NhaSanXuat);
	};

	@GetMapping("/")
	public Map<String, Object> getAllNhaSanXuat(@RequestParam(required = false) String searchString,
			@RequestParam(required = false) String sortData, @RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) Integer page) {
		return NhaSanXuatService.getAllNhaSanXuat(searchString, page, pageSize,sortData);
	};

	@GetMapping("/{id}")
	public Map<String, Object> getNhaSanXuatById(@PathVariable Long id) {
		return NhaSanXuatService.getNhaSanXuatById(id);
	};

	@PutMapping("/{id}")
	public Map<String, Object> updateNhaSanXuat(NhaSanXuat NhaSanXuat) {
		return NhaSanXuatService.updateNhaSanXuat(NhaSanXuat);
	};

	@DeleteMapping("/{id}")
	public Map<String, Object> deleteNhaSanXuat(@PathVariable Long id) {
		return NhaSanXuatService.deleteNhaSanXuat(id);
	};
}
