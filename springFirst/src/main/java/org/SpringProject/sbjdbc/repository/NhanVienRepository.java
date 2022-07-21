package org.SpringProject.sbjdbc.repository;

import org.SpringProject.sbjdbc.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long>  {
    
}