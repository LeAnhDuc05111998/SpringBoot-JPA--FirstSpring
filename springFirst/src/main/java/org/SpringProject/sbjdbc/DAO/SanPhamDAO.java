package org.SpringProject.sbjdbc.DAO;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.SpringProject.sbjdbc.common.common;
import org.SpringProject.sbjdbc.entity.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class SanPhamDAO{
	
	@Autowired
	private EntityManager  entityManager;
	
	public List<SanPham> InfoSanPham(String searchString, Pageable pageable, String sortData) {
		List<SanPham> sanPhams = new ArrayList<SanPham>();
		try {
			String nhapGia = null;
			String tenSP = null;
			StringBuilder sql = new StringBuilder();
			sql.append(" FROM SanPham sp ");
			sql.append(" WHERE 1=1");
			//sql.append(" ");
			if (searchString != null && searchString.length() > 0) {
				Map<String, String> dataSearch = common.splitRequestParamsFromURL(searchString);
				tenSP = dataSearch.get("tenSP");
				if(tenSP!= null) {
					sql.append(" AND sp.tenSP = :tenSP ");
				}
				nhapGia = dataSearch.get("nhapGia");
				if(nhapGia!= null) {
					sql.append(" AND sp.gia = :nhapGia ");
				}
			}
			if(sortData != null && sortData.length() > 0) {
				sql.append(" ORDER BY ").append(common.convertSortDataWithAlias(sortData, "sp"));
			}
			TypedQuery<SanPham> result =  entityManager.createQuery(sql.toString(), SanPham.class);
			if(tenSP!= null) {
				result.setParameter("tenSP", tenSP);
			}
			if(nhapGia!= null) {
				BigDecimal num = BigDecimal.valueOf(Double.valueOf(nhapGia));
				assertEquals(new BigDecimal(nhapGia), num);
				result.setParameter("nhapGia", num);
			}
			if (pageable != null) {
				sanPhams = result.setFirstResult((int) pageable.getOffset())
						.setMaxResults(pageable.getPageSize()).getResultList();
			} else {
				sanPhams = result.getResultList();
			}			
			return sanPhams;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Long totalInfoSanPham(String searchString) {
		try {
			String tenSP = null;
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT COUNT(sp) ");
			sql.append(" FROM SanPham sp ");
			sql.append(" WHERE 1=1");
			sql.append(" AND sp.isDelete = false ");

			if (searchString != null && searchString.length() > 0) {
				Map<String, String> dataSearch = common.splitRequestParamsFromURL(searchString);
				tenSP = dataSearch.get("tenSP");
				if (tenSP != null) {
					sql.append(" AND sp.tenSP = :tenSP ");
				}
			}
			TypedQuery<Long> ressult = entityManager.createQuery(sql.toString(), Long.class);

			if (tenSP != null) {
				ressult.setParameter("tenSP", tenSP);
			}
			return ressult.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
}
