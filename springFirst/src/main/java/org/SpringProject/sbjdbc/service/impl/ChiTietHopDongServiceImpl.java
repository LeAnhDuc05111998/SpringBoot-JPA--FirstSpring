package org.SpringProject.sbjdbc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.SpringProject.sbjdbc.dto.HopDongLaoDongDto;
import org.SpringProject.sbjdbc.entity.HopDongLaoDong;
import org.SpringProject.sbjdbc.repository.ChiTietHopDongRepository;
import org.SpringProject.sbjdbc.service.ChiTietHopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChiTietHopDongServiceImpl implements ChiTietHopDongService {
	
	@Autowired
	private ChiTietHopDongRepository chiTietHopDongRepository;
    
	@Override
	public Map<String,Object> saveHopDong (HopDongLaoDongDto hopDongLaoDongDto){
		Map<String,Object> ketquaSave = new HashMap<String,Object>();
		try {
			List<HopDongLaoDong> listHDLD = new ArrayList<>();
			if(listHDLD !=null) {
					HopDongLaoDong HD = new HopDongLaoDong();
					HD.setIdNhanVien(hopDongLaoDongDto.getIdNhanVien());
					HD.setIdCuaHang(hopDongLaoDongDto.getIdCuaHang());
					HD.setLuongKhoiDiem(hopDongLaoDongDto.getLuongKhoiDiem());
					HD.setSoNgayPhep(hopDongLaoDongDto.getSoNgayPhep());
					HD.setNgayHetHan(hopDongLaoDongDto.getNgayHetHan());
					listHDLD.add(HD);
			}
			ketquaSave.put("ketquaSave",chiTietHopDongRepository.saveAll(listHDLD));
			return ketquaSave;
		}catch(Exception e) {
			return null;
		}	
	}
	
	@Override
	public Map<String, Object> getAllHopDong () {
		Map<String, Object> ketquaGetALL = new HashMap<String, Object>();
		try {
			ketquaGetALL.put("List Total Contract",chiTietHopDongRepository.findAll());
			return ketquaGetALL;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Map<String, Object> getHopDongById(Long id) {
		Map<String, Object> kqGetById = new HashMap<String, Object>();
		try {
			kqGetById.put("result", chiTietHopDongRepository.findById(id));
			return kqGetById;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Map<String, Object> updateHopDong(HopDongLaoDong hopDongLaoDong) {
		Map<String, Object> ketquaSua = new HashMap<String, Object>();
		try {
			HopDongLaoDong detailContract = chiTietHopDongRepository.findById(hopDongLaoDong.getIdContract()).get();
			detailContract.setIdNhanVien(hopDongLaoDong.getIdNhanVien());
			detailContract.setIdCuaHang(hopDongLaoDong.getIdCuaHang());
			detailContract.setLuongKhoiDiem(hopDongLaoDong.getLuongKhoiDiem());
			detailContract.setLuongTangTheoThang(hopDongLaoDong.getLuongTangTheoThang());
			detailContract.setThuongDoanhThu(hopDongLaoDong.getThuongDoanhThu());
			detailContract.setSoNgayPhep(hopDongLaoDong.getSoNgayPhep());
			detailContract.setNgayHetHan(hopDongLaoDong.getNgayHetHan());
			ketquaSua.put("Hoan Thanh", detailContract);
			return ketquaSua;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Map<String, Object> deleteHopDong(Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Optional<HopDongLaoDong> opAdd = chiTietHopDongRepository.findById(id);
			if (opAdd.isPresent()) {
				chiTietHopDongRepository.delete(opAdd.get());
				result.put("result", "Da Xoa Thanh Cong");
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
