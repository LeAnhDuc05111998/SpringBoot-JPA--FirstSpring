package org.SpringProject.sbjdbc.controller;

import java.util.Map;

import org.SpringProject.sbjdbc.entity.Location;
import org.SpringProject.sbjdbc.service.LocationService;
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
@RequestMapping("/api/locationStore")
public class LocationController {
	
	@Autowired
	LocationService locationService;
	
	@PostMapping("/")
	public Map<String,Object> saveLocation ( @RequestBody Location location) {
		return locationService.saveLocation(location);
	}
	@GetMapping("/")
	public Map<String,Object> getAllLocation () {
		return locationService.getAllLocation();		
	}
	@GetMapping("/{idCuaHang}")
	Map<String,Object> getLocationById ( @PathVariable Location location){
		return locationService.getLocationById(location);	
	}
	@PutMapping("/{idCuaHang}")
	Map<String,Object> updateLocation (Location location){
		return locationService.updateLocation(location);		
	}
	@DeleteMapping("/{idCuaHang}")
	Map<String,Object> deleteLocation ( @PathVariable Long idCuaHang){
		return locationService.deleteLocation(idCuaHang);		
	}
}
