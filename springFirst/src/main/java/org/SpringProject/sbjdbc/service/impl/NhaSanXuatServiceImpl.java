package org.SpringProject.sbjdbc.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.SpringProject.sbjdbc.DAO.NhaSanXuatDAO;
import org.SpringProject.sbjdbc.entity.NhaSanXuat;
import org.SpringProject.sbjdbc.repository.NhaSanXuatRepository;
import org.SpringProject.sbjdbc.service.NhaSanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NhaSanXuatServiceImpl implements NhaSanXuatService {
	@Autowired
	private NhaSanXuatRepository NhaSanXuatRepository;
	@Autowired
	private NhaSanXuatDAO nhaSanXuatDAO;
	@Override
	public Map<String, Object> saveNhaSanXuat(NhaSanXuat NhaSanXuat) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("result", NhaSanXuatRepository.save(NhaSanXuat));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Map<String, Object> getAllNhaSanXuat(String search, Integer page, Integer pageSize, String sortData) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> pagination = new HashMap<String, Object>();
		try {
			Pageable pageable = null;
			if (page!= null && pageSize!= null) {
				pageable = PageRequest.of(page - 1, pageSize);
				pagination.put("page", page);
				pagination.put("pageSize", pageSize);
				pagination.put("total", nhaSanXuatDAO.totalInfoNhaSanXuat(search));
			}
			result.put("Total result", nhaSanXuatDAO.InfoNhaSanXuat(search, pageable, sortData));
			result.put("pagination NSX", pagination);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Map<String, Object> getNhaSanXuatById(Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("result", NhaSanXuatRepository.findById(id));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Map<String, Object> updateNhaSanXuat(NhaSanXuat NhaSanXuat) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			NhaSanXuat nhaSanXuat = NhaSanXuatRepository.findById(NhaSanXuat.getId()).get();
			nhaSanXuat.setTenNhaSX(NhaSanXuat.getTenNhaSX());
			nhaSanXuat.setDiaChi(NhaSanXuat.getDiaChi());
			nhaSanXuat.setSoDT(NhaSanXuat.getSoDT());
			result.put("result", nhaSanXuat);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Map<String, Object> deleteNhaSanXuat(Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Optional<NhaSanXuat> opAdd = NhaSanXuatRepository.findById(id);
			if (opAdd.isPresent()) {
				opAdd.get().setIsDelete(true);
				NhaSanXuatRepository.save(opAdd.get());
				result.put("result", "Da xoa");
			}
			result.put("result", "Xoa");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
