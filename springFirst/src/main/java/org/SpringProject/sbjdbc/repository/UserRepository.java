package org.SpringProject.sbjdbc.repository;

import org.SpringProject.sbjdbc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
      
}
