package org.SpringProject.sbjdbc.controller;

import java.util.Map;

import org.SpringProject.sbjdbc.entity.Address;
import org.SpringProject.sbjdbc.service.AddressService;
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
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping("/")
	public Map<String, Object> saveAddress(@RequestBody Address Address) {
		return addressService.saveAddress(Address);
	};

	@GetMapping("/")
	public Map<String, Object> getAllAddresss() {
		return addressService.getAllAddresss();
	};

	@GetMapping("/{id}")
	public Map<String, Object> getAddressById(@PathVariable Long id) {
		return addressService.getAddressById(id);
	};

	@PutMapping("/{id}")
	public Map<String, Object> updateAddress(Address Address) {
		return addressService.updateAddress(Address);
	};

	@DeleteMapping("/{id}")
	public Map<String, Object> deleteAddress(@PathVariable Long id) {
		return addressService.deleteAddress(id);
	};
}
