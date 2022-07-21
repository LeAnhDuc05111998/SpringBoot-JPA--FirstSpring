package org.SpringProject.sbjdbc.service;

import java.util.Map;
import org.SpringProject.sbjdbc.entity.NhanVien;

public interface NhanVienService {
    Map<String,Object> saveNhanVien (NhanVien nhanVien);
    
    Map<String,Object> getAllNhanVien ();
    
    Map<String,Object> getNhanVienById (NhanVien nhanVien);
    
    Map<String,Object> updateNhanVien (NhanVien nhanVien);
    
    Map<String,Object> deleteNhanVien (Long idNhanVien);
}
