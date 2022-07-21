package org.SpringProject.sbjdbc.service;

import java.util.Map;

import org.SpringProject.sbjdbc.entity.Address;

public interface AddressService {
	Map<String, Object> saveAddress(Address Address);

	Map<String, Object> getAllAddresss();

	Map<String, Object> getAddressById(Long id);

	Map<String, Object> updateAddress(Address Address);

	Map<String, Object> deleteAddress(Long id);
}
