package org.SpringProject.sbjdbc.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.SpringProject.sbjdbc.entity.ChiTietHopTac;
import org.SpringProject.sbjdbc.repository.ChiTietHopTacRepository;
import org.SpringProject.sbjdbc.service.ChiTietHopTacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChiTietHopTacServiceImpl implements ChiTietHopTacService {
    
	@Autowired
	private ChiTietHopTacRepository chiTietHopTacRepository;
	
	@Override
	public Map<String,Object> saveChiTietHopTac (ChiTietHopTac chiTietHopTac){
		Map<String,Object> ketquaSave = new HashMap<String,Object>();{
		    try {
				ketquaSave.put("resultSave", chiTietHopTacRepository.save(chiTietHopTac));
				return ketquaSave;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}			
		}	
	}
	@Override
	public Map<String,Object> getAllChiTietHopTac () {
		Map<String,Object> ketquaGetAll = new HashMap<String,Object>();{
		    try {
			   ketquaGetAll.put("resultGetAll", chiTietHopTacRepository.findAll());
			   return ketquaGetAll;
		    }catch(Exception e) {
			   e.printStackTrace();
			   return null;
		    }
		}
	}
	@Override
	public Map<String,Object> getByIdCTHT (Long id){
		Map<String,Object> ketquaGet = new HashMap<String,Object>();
		try {
			ketquaGet.put("resultGet", chiTietHopTacRepository.findById(id));
			return ketquaGet;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Map<String, Object> updateChiTietHopTac(ChiTietHopTac chiTietHopTac) {
		Map<String, Object> ketquaSua = new HashMap<String, Object>();
		try {
			ChiTietHopTac chiTietHopTacUpdated = chiTietHopTacRepository.findById(chiTietHopTac.getIdHopTac()).get();
			if(chiTietHopTacUpdated!= null);{
			chiTietHopTacUpdated.setNgayBatDau(chiTietHopTac.getNgayBatDau());
			chiTietHopTacUpdated.setSoThang(chiTietHopTac.getSoThang());
			ketquaSua.put("result", chiTietHopTacUpdated);
			}
			return ketquaSua;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Map<String, Object> deleteChiTietHopTac(Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Optional<ChiTietHopTac> opAdd =chiTietHopTacRepository.findById(id);
			if (opAdd.isPresent()) {
				chiTietHopTacRepository.delete(opAdd.get());
				result.put("resultDelete", "Da xoa thanh cong");
			}else {
			    result.put("result", "Khong tim thay data");
			}
			return result;	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
