package org.SpringProject.sbjdbc.service.impl;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.SpringProject.sbjdbc.DAO.UserDAO;
import org.SpringProject.sbjdbc.entity.User;
import org.SpringProject.sbjdbc.repository.UserRepository;
import org.SpringProject.sbjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository  userRepository;
	@Autowired
	private UserDAO userDAO;
	@Override
    public Map<String, Object>  saveUser(User User) {
    	Map<String, Object > result = new HashMap<String, Object>();
    	try {
    		result.put("result",userRepository.save(User));
    		return result;
    	    }
    	catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	    }
    }
	@Override
	public Map<String, Object>  getAllUser(String search, Integer page, Integer pageSize, String sortData) {
    	Map<String, Object > result = new HashMap<String, Object>();
    	Map<String, Object > pagination = new HashMap<String, Object>();
    	try {
			Pageable pageable = null;
			if (page != null && pageSize != null) {
				pageable = PageRequest.of(page - 1, pageSize);
				pagination.put("page", page);
				pagination.put("pageSize", pageSize);
				pagination.put("total", userDAO.totalInfouser(search));
			}
			result.put("result", userDAO.Infouser(search, sortData, pageable));
			result.put("pagination User", pagination);	
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
	@Override
	public Map<String, Object>  getUserById(Long id) {
    	Map<String, Object > result = new HashMap<String, Object>();
    	try {
    		result.put("result", userRepository.findById(id));
    		return result;
    	    }
    	catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	    }
	}
	@Override
	public Map<String, Object> updateUser(User User) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			User user = userRepository.findById(User.getId()).get();
			user.setHoTen(User.getHoTen());
			user.setDiaChi(User.getDiaChi());
			user.setSoDT(User.getSoDT());
			user.setNgaySinh(User.getNgaySinh());
			user.setGioiTinh(User.getGioiTinh());
			result.put("result", user);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Map<String, Object> deleteUser(Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Optional<User> opAdd = userRepository.findById(id);
			if (opAdd.isPresent()) {
				userRepository.delete(opAdd.get());
				result.put("result", "Da xoa");
			}
			result.put("result", "Xoa");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
