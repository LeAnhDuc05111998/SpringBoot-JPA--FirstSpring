package org.SpringProject.sbjdbc.repository;

import org.SpringProject.sbjdbc.entity.CuaHangDaiLy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CuaHangDaiLyRepository extends JpaRepository<CuaHangDaiLy, Long> {
    
}
