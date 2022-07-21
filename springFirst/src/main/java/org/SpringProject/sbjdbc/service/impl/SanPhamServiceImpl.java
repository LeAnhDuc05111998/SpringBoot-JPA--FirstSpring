package org.SpringProject.sbjdbc.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.SpringProject.sbjdbc.DAO.SanPhamDAO;
import org.SpringProject.sbjdbc.entity.SanPham;
import org.SpringProject.sbjdbc.repository.SanPhamRepository;
import org.SpringProject.sbjdbc.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SanPhamServiceImpl implements SanPhamService{
	@Autowired
	private SanPhamRepository  SanPhamRepository;
	@Autowired
	private SanPhamDAO SanPhamDAO;
	@Override
    public Map<String, Object>  saveSanPham(SanPham SanPham) {
    	Map<String, Object > result = new HashMap<String, Object>();
    	try {
    		result.put("result",SanPhamRepository.save(SanPham));
    		return result;
    	    }
    	catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	    }
    }
	@Override
	public Map<String, Object> getAllSanPham(String search, Integer page, Integer pageSize, String sortData) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> pagination = new HashMap<String, Object>();
		try {
			Pageable pageable = null;
			if(page!= null && pageSize!= null) {
				pageable = PageRequest.of(page - 1, pageSize);
				pagination.put("page",page );
				pagination.put("pageSize",pageSize);
				pagination.put("totalPageSP",SanPhamDAO.totalInfoSanPham(search));
				
			}
			result.put("result", SanPhamDAO.InfoSanPham(search, pageable, sortData));
			result.put("pagination SP", pagination);
			
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Map<String, Object>  getSanPhamById(Long id) {
    	Map<String, Object > result = new HashMap<String, Object>();
    	try {
    		result.put("result", SanPhamRepository.findById(id));
    		return result;
    	    }
    	catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	    }
	}
	@Override
	public Map<String, Object> updateSanPham(SanPham SanPham) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			SanPham sanPham = SanPhamRepository.findById(SanPham.getId()).get();
			sanPham.setTenSP(SanPham.getTenSP());
			sanPham.setGia(SanPham.getGia());
			sanPham.setNguonGoc(SanPham.getNguonGoc());
			sanPham.setNgaySX(SanPham.getNgaySX());
			sanPham.setNgayHetHan(SanPham.getNgayHetHan());
			result.put("result", SanPham);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Map<String, Object> deleteSanPham(Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Optional<SanPham> opAdd = SanPhamRepository.findById(id);
			if (opAdd.isPresent()) {
				opAdd.get().setIsDelete(true);
				SanPhamRepository.save(opAdd.get());
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
