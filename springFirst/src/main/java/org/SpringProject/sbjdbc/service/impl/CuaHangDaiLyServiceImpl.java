package org.SpringProject.sbjdbc.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.SpringProject.sbjdbc.entity.CuaHangDaiLy;
import org.SpringProject.sbjdbc.repository.CuaHangDaiLyRepository;
import org.SpringProject.sbjdbc.service.CuaHangDaiLyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuaHangDaiLyServiceImpl implements CuaHangDaiLyService {
	
    @Autowired
	CuaHangDaiLyRepository cuaHangDaiLyRepository;
    @Override
    public Map<String,Object> saveCuaHang (CuaHangDaiLy cuaHangDaiLy) {
    	Map<String,Object> ketquaSave = new HashMap<String,Object>();{
    	try {
    		ketquaSave.put("resultSave", cuaHangDaiLyRepository.save(cuaHangDaiLy));
    		return ketquaSave;   		
    	    }catch(Exception e) {
    	    	e.printStackTrace();
    	    	return null;   	    	
    	    }
    	}  	
    }
    @Override
    public Map<String,Object> getAllCuaHang () {
	    Map<String,Object> ketquaGetAll = new HashMap<String,Object>(); {
        try {
        	ketquaGetAll.put("resultGetAll",cuaHangDaiLyRepository.findAll());
        	return ketquaGetAll;
        }catch(Exception e) {
        	e.printStackTrace();
        	return null;
            }
    	}   	
    }
    @Override
    public Map<String,Object> getCuaHangById (Long idCuaHang){
    	Map<String,Object> ketquaGet = new HashMap<String,Object>();
    	try {
    		ketquaGet.put("resultGet",cuaHangDaiLyRepository.findById(idCuaHang));
    		return ketquaGet;
    	}catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	    }
    }
    @Override
    public Map<String,Object> updateCuaHang (CuaHangDaiLy cuaHangDaiLy) {
    	Map<String,Object> ketquaUpdate = new HashMap<String,Object>();
    	try {
    		CuaHangDaiLy DetailCuaHang = cuaHangDaiLyRepository.getById(cuaHangDaiLy.getIdCuaHang());
    		DetailCuaHang.setTenCuaHang(cuaHangDaiLy.getTenCuaHang());
    		DetailCuaHang.setQuanLy(cuaHangDaiLy.getQuanLy());
    		DetailCuaHang.setNgayKhaiTruong(cuaHangDaiLy.getNgayKhaiTruong());
    		DetailCuaHang.setChuongTrinhUuDai(cuaHangDaiLy.getChuongTrinhUuDai());
    	    ketquaUpdate.put("result Update", DetailCuaHang);
        	return ketquaUpdate;
    	}catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    @Override
    public Map<String,Object> xoaCuaHang (Long idCuaHang){
    	Map<String,Object> ketquaXoa = new HashMap<String,Object>();
    		try {
    		Optional<CuaHangDaiLy> Opt =cuaHangDaiLyRepository.findById(idCuaHang);
    		if(Opt.isPresent()){
    			cuaHangDaiLyRepository.delete(Opt.get());
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
