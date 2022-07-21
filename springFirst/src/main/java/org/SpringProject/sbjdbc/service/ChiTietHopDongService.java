package org.SpringProject.sbjdbc.service;

import java.util.Map;
import org.SpringProject.sbjdbc.dto.HopDongLaoDongDto;
import org.SpringProject.sbjdbc.entity.HopDongLaoDong;

public interface ChiTietHopDongService {
	
	public Map<String,Object> saveHopDong (HopDongLaoDongDto hopDongLaoDongDto);
	
	public Map<String, Object> getAllHopDong ();
	
	public Map<String, Object> getHopDongById(Long id);
	
	public Map<String, Object> updateHopDong(HopDongLaoDong hopDongLaoDong);
	
	public Map<String, Object> deleteHopDong(Long id);

}
