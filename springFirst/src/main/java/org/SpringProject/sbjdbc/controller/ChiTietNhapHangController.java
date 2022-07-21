package org.SpringProject.sbjdbc.controller;

import java.util.Map;
import org.SpringProject.sbjdbc.dto.ChiTietNhapHangDto;
import org.SpringProject.sbjdbc.service.ChiTietNhapHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detail")
public class ChiTietNhapHangController {

	@Autowired
	private ChiTietNhapHangService ChiTietNhapHangService;

	@PostMapping("/")
	public Map<String, Object> saveChiTietNhapHang(@RequestBody ChiTietNhapHangDto ChiTietNhapHang) {
		return ChiTietNhapHangService.saveChiTietNhapHang(ChiTietNhapHang);
	};

	@GetMapping("/")
	public Map<String, Object> getAllChiTietNhapHang(@RequestParam(required = false) String searchString,@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer pageSize) {
		return ChiTietNhapHangService.getAllChiTietNhapHang(searchString, page, pageSize);
	};

	@GetMapping("/{id}")
	public Map<String, Object> getChiTietNhapHangById(@PathVariable Long id) {
		return ChiTietNhapHangService.getChiTietNhapHangById(id);
	};

	//@PutMapping("/")
	//public Map<String, Object> updateChiTietNhapHang(ChiTietNhapHang ChiTietNhapHang) {
		//return ChiTietNhapHangService.updateChiTietNhapHang(ChiTietNhapHang);
	//};
	
}
