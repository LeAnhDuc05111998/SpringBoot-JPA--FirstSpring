package org.SpringProject.sbjdbc.service;

import java.util.Map;

import org.SpringProject.sbjdbc.entity.NhaSanXuat;

public interface NhaSanXuatService {

	Map<String, Object> saveNhaSanXuat(NhaSanXuat nhaSanXuat);

	Map<String, Object> getAllNhaSanXuat(String search, Integer page, Integer pageSize , String sortData);

	Map<String, Object> getNhaSanXuatById(Long id);

	Map<String, Object> updateNhaSanXuat(NhaSanXuat nhaSanXuat);

	Map<String, Object> deleteNhaSanXuat(Long id);

}
