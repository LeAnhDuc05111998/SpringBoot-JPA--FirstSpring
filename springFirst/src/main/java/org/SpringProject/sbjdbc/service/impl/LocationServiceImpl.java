package org.SpringProject.sbjdbc.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.SpringProject.sbjdbc.entity.Location;
import org.SpringProject.sbjdbc.repository.LocationRepository;
import org.SpringProject.sbjdbc.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
     
	@Autowired
	LocationRepository locationRepository;
	@Override
	public Map<String,Object> saveLocation (Location location){
    	Map<String,Object> ketquaSave = new HashMap<String,Object>();{
    	try {
    		ketquaSave.put("resultSave", locationRepository.save(location));
    		return ketquaSave;   		
    	    }catch(Exception e) {
    	    	e.printStackTrace();
    	    	return null;   	    	
    	    }
    	}  
	}
	@Override
	public Map<String,Object> getAllLocation () {		
	    Map<String,Object> ketquaGetAll = new HashMap<String,Object>(); {
	        try {
	        	ketquaGetAll.put("resultGetAll",locationRepository.findAll());
	        	return ketquaGetAll;
	        }catch(Exception e) {
	        	e.printStackTrace();
	        	return null;
	            }
	    	}
	}
	@Override
	public Map<String,Object> getLocationById (Location location) {
	    Map<String,Object> ketquaGetAll = new HashMap<String,Object>(); {
	        try {
	        	ketquaGetAll.put("resultGetAll",locationRepository.findAll());
	        	return ketquaGetAll;
	        }catch(Exception e) {
	        	e.printStackTrace();
	        	return null;
	            }
	    	}     	
	}
	@Override
	public Map<String,Object> updateLocation (Location location) {
    	Map<String,Object> ketquaGet = new HashMap<String,Object>();
    	try {
    		Location locationUpdate = locationRepository.findById(location.getIdDiaDiem()).get();
    		locationUpdate.setSoHieuDaiLy(location.getSoHieuDaiLy());
    		locationUpdate.setStreet(location.getStreet());
    		locationUpdate.setCity(location.getCity());
    		ketquaGet.put("result Update", locationUpdate);
    		return ketquaGet;
    	}catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	    }	
	}
	@Override
	public Map<String,Object> deleteLocation (Long idLocation) {
		Map<String,Object> ketquaXoa = new HashMap<String,Object>();{
		try {
			Optional<Location> Opt = locationRepository.findById(idLocation);
			if(Opt.isPresent()) {
				locationRepository.delete(Opt.get());
				ketquaXoa.put("resultXoa", "Du Lieu da dc xoa");
			}else {
			    ketquaXoa.put("resultXoa", "Du Lieu ko ton tai");
			}
			return ketquaXoa;
		}catch(Exception e) {
            e.printStackTrace();
            return null;
		    }		
	    }
	}
}
