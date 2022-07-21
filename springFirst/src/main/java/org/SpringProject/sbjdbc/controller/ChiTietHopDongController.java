package org.SpringProject.sbjdbc.controller;

import java.util.Map;

import org.SpringProject.sbjdbc.dto.HopDongLaoDongDto;
import org.SpringProject.sbjdbc.entity.HopDongLaoDong;
import org.SpringProject.sbjdbc.service.ChiTietHopDongService;
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
@RequestMapping("/api/contract")
public class ChiTietHopDongController {
	
	@Autowired
	private ChiTietHopDongService chiTietHopDongService;
	
	@PostMapping("/")
	public Map<String, Object> saveHopDong(@RequestBody HopDongLaoDongDto hopDongLaoDongDto) {
		return chiTietHopDongService.saveHopDong(hopDongLaoDongDto);
	};

	@GetMapping("/")
	public Map<String, Object> getAllHopDong() {
		return chiTietHopDongService.getAllHopDong();
	};

	@GetMapping("/{id}")
	public Map<String, Object> getHopDongById(@PathVariable Long id) {
		return chiTietHopDongService.getHopDongById(id);
	};

	@PutMapping("/{id}")
	public Map<String, Object> updateHopDong(HopDongLaoDong hopDongLaoDong) {
		return chiTietHopDongService.updateHopDong(hopDongLaoDong);
	};

	@DeleteMapping("/{id}")
	public Map<String, Object> deleteHopDong(@PathVariable Long id) {
		return chiTietHopDongService.deleteHopDong(id);
	};

}
