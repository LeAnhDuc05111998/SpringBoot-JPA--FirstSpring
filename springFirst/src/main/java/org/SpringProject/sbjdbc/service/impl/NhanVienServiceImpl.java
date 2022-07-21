package org.SpringProject.sbjdbc.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.SpringProject.sbjdbc.entity.NhanVien;
import org.SpringProject.sbjdbc.repository.NhanVienRepository;
import org.SpringProject.sbjdbc.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienServiceImpl implements NhanVienService {
	
    @Autowired 
	NhanVienRepository nhanVienRepository;
    @Override
    public Map<String,Object> saveNhanVien (NhanVien nhanVien){
    	Map<String,Object> ketquaSave = new HashMap<String,Object>(); {
    	try {
    		ketquaSave.put("resultSave", nhanVienRepository.save(nhanVien));
    		return ketquaSave; 
    	}catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	    }
    	}   	
    }
    @Override
    public Map<String,Object> getAllNhanVien (){
    	Map<String,Object> ketquaGetAll = new HashMap<String,Object>(); {
        try {
        	ketquaGetAll.put("resultGetAll",nhanVienRepository.findAll());
        	return ketquaGetAll;
        }catch(Exception e) {
        	e.printStackTrace();
        	return null;
            }
    	}   	
    }
    @Override
    public Map<String,Object> getNhanVienById (NhanVien nhanVien){
    	Map<String,Object> ketquaGet = new HashMap<String,Object>();{
    	try {
    		ketquaGet.put("resultGet",nhanVienRepository.findById(nhanVien.getIdNhanVien()));
    		return ketquaGet;
    	}catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	    }
    	}  	
    }
    @Override
    public Map<String,Object> updateNhanVien (NhanVien nhanVien){
		Map<String,Object> ketquaUpdate = new HashMap<String,Object>();
		try {
			NhanVien getNhanVien = nhanVienRepository.findById(nhanVien.getIdNhanVien()).get();
			getNhanVien.setTenNhanVien(nhanVien.getTenNhanVien());
			getNhanVien.setGioLamViec(nhanVien.getGioLamViec());
			getNhanVien.setLuong(nhanVien.getLuong());
			getNhanVien.setThanhTich(nhanVien.getThanhTich());
			ketquaUpdate.put("result Update",nhanVien);
			return ketquaUpdate;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}   	
    }
    @Override
    public Map<String,Object> deleteNhanVien (Long idNhanVien){
    	Map<String,Object> ketquaXoa = new HashMap<String,Object>();{
    		try {
    		Optional<NhanVien> Opt =nhanVienRepository.findById(idNhanVien);
    		if(Opt.isPresent()){
    			nhanVienRepository.delete(Opt.get());
    			ketquaXoa.put("result","Da xoa");
    		 }else {
    		    ketquaXoa.put("result","Khong ton tai du lieu de xoa");
    		 }
    		return ketquaXoa;
    		}catch(Exception e) {
    			e.printStackTrace();
    			return null;
    		}
    	}	
    }
}
