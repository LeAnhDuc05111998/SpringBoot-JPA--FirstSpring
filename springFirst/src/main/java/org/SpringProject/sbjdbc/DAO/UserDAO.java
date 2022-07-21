package org.SpringProject.sbjdbc.DAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.SpringProject.sbjdbc.common.common;
import org.SpringProject.sbjdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	
	@Autowired
	private EntityManager entityManager;
	@SuppressWarnings("deprecation")
	public List<User> Infouser(String searchString, String sortData, Pageable pageable) {
		List<User> users = new ArrayList<User>();
		try {
			String nhapTuKhoa = null;
			String hoTen = null;
			String nhapNgaySinh = null;
			StringBuilder sql = new StringBuilder();
			sql.append(" FROM User us ");
			sql.append(" WHERE 1=1 ");
			if (searchString != null && searchString.length() > 0) {
				Map<String, String> dataSearch = common.splitRequestParamsFromURL(searchString);
				nhapTuKhoa = dataSearch.get("nhapTuKhoa");
				if(nhapTuKhoa!=null) {
					sql.append(" AND UPPER(us.diaChi) LIKE :nhapTuKhoa ");
					sql.append(" OR UPPER(us.hoTen) LIKE :nhapTuKhoa ");
					sql.append(" OR UPPER(us.soDT) LIKE :nhapTuKhoa ");			
				}
				hoTen = dataSearch.get("hoTen");
				if(hoTen != null) {
					sql.append(" AND UPPER(us.hoTen) = :hoTen ");
				}
				nhapNgaySinh=dataSearch.get("nhapNgaySinh");
				if(nhapNgaySinh!=null) {
					sql.append(" AND us.ngaySinh = :nhapNgaySinh ");
				}
			}
			if (sortData != null && sortData.length() > 0) {
				sql.append(" ORDER BY ").append(common.convertSortDataWithAlias(sortData, "us"));
			}
			TypedQuery<User> ressult = entityManager.createQuery(sql.toString(), User.class);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			if (hoTen != null) {
				ressult.setParameter("hoTen", "%" + hoTen.toUpperCase() + "%");
			}
            if(nhapTuKhoa != null) {
            	ressult.setParameter("nhapTuKhoa","%" + nhapTuKhoa.toUpperCase() + "%");
            }
            if(nhapNgaySinh!=null) {
				String date = nhapNgaySinh;        
		        LocalDate localDate = LocalDate.parse(date, formatter);
		        ressult.setParameter("nhapNgaySinh", localDate);    
            }
			if (pageable != null) {
				users = ressult.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize())
						.getResultList();
			} else {
				users = ressult.getResultList();
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Long totalInfouser(String searchString) {
		try {
			String hoTen = null;

			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT COUNT(us) ");
			sql.append(" FROM User us ");
			sql.append(" WHERE 1=1");
			sql.append(" AND us.isDelete = false ");
			if (searchString != null && searchString.length() > 0) {
				Map<String, String> dataSearch = common.splitRequestParamsFromURL(searchString);
				hoTen = dataSearch.get("hoTen");
				if (hoTen != null) {
					sql.append(" AND us.hoTen = :hoTen ");
				}
			}
			TypedQuery<Long> ressult = entityManager.createQuery(sql.toString(), Long.class);
			if (hoTen != null) {
				ressult.setParameter("hoTen", hoTen);
			}
			return ressult.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
