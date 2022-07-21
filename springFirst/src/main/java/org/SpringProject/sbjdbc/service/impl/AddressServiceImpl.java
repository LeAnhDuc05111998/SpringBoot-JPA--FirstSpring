package org.SpringProject.sbjdbc.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.SpringProject.sbjdbc.entity.Address;
import org.SpringProject.sbjdbc.repository.AddressRepository;
import org.SpringProject.sbjdbc.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository AddressRepository;

	@Override
	public Map<String, Object> saveAddress(Address Address) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("result", AddressRepository.save(Address));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Map<String, Object> getAllAddresss() {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("result", AddressRepository.findAll());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Map<String, Object> getAddressById(Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("result", AddressRepository.findById(id));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Map<String, Object> updateAddress(Address Address) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Address address = AddressRepository.findById(Address.getId()).get();
			address.setCountry(Address.getCountry());
			address.setPhoneNumber(Address.getPhoneNumber());
			result.put("result", address);
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Map<String, Object> deleteAddress(Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Optional<Address> opAdd = AddressRepository.findById(id);
			if (opAdd.isPresent()) {
				AddressRepository.delete(opAdd.get());
				result.put("result", "Da xoa");
			}else {
			result.put("result", "khong tim thay data");
			}
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}