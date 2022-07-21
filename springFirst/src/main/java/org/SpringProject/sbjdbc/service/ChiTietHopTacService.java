package org.SpringProject.sbjdbc.service;

import java.util.Map;
import org.SpringProject.sbjdbc.entity.ChiTietHopTac;

public interface ChiTietHopTacService {

	Map<String, Object> saveChiTietHopTac(ChiTietHopTac chiTietHopTac);
	
	Map<String, Object> getAllChiTietHopTac ();
	
	Map<String, Object> getByIdCTHT(Long Id);
	
	Map<String, Object> updateChiTietHopTac(ChiTietHopTac chiTietHopTac);
	
	Map<String, Object> deleteChiTietHopTac(Long Id);
      
}
