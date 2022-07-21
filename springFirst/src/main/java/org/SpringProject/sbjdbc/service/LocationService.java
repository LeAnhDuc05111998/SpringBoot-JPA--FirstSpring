package org.SpringProject.sbjdbc.service;

import java.util.Map;

import org.SpringProject.sbjdbc.entity.Location;

public interface LocationService {
        
	public Map<String,Object> saveLocation (Location location);
	
	public Map<String,Object> getAllLocation ();
	
	public Map<String,Object> getLocationById (Location location);
	
	public Map<String,Object> updateLocation (Location location);
	
	public Map<String,Object> deleteLocation (Long idLocation);
}
