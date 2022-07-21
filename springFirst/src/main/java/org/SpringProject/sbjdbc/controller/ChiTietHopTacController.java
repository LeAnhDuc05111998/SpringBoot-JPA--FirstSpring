package org.SpringProject.sbjdbc.controller;

import java.util.Map;
import org.SpringProject.sbjdbc.entity.ChiTietHopTac;
import org.SpringProject.sbjdbc.service.ChiTietHopTacService;
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
@RequestMapping("/api/hoptac")
public class ChiTietHopTacController {
    
	@Autowired
	private ChiTietHopTacService chiTietHopTacService;
	
	@PostMapping("/")
	public Map<String, Object> saveChiTietHopTac(@RequestBody ChiTietHopTac chiTietHopTac) {
		return chiTietHopTacService.saveChiTietHopTac(chiTietHopTac);
	};

	@GetMapping("/")
	public Map<String, Object> getAllAddresss() {
		return chiTietHopTacService.getAllChiTietHopTac();
	};

	@GetMapping("/{id}")
	public Map<String, Object> getAddressById(@PathVariable Long id) {
		return chiTietHopTacService.getByIdCTHT(id);
	};

	@PutMapping("/{id}")
	public Map<String, Object> updateAddress(ChiTietHopTac chiTietHopTac) {
		return chiTietHopTacService.updateChiTietHopTac(chiTietHopTac);
	};

	@DeleteMapping("/{id}")
	public Map<String, Object> deleteChiTietHopTac(@PathVariable Long id) {
		return chiTietHopTacService.deleteChiTietHopTac(id);
	};
}
