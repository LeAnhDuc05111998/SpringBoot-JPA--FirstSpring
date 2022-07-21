package org.SpringProject.sbjdbc.DAO;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.SpringProject.sbjdbc.common.common;
import org.SpringProject.sbjdbc.entity.NhaSanXuat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NhaSanXuatDAO {
	@Autowired
	private EntityManager entityManager;
	
	public List<NhaSanXuat> InfoNhaSanXuat(String searchString,  Pageable pageable, String sortData) {
		List<NhaSanXuat> nhaSanXuats = new ArrayList<NhaSanXuat>();
		try {
            String SDT = null; 
			String tenNhaSX = null;
			StringBuilder sql = new StringBuilder();
			sql.append(" FROM NhaSanXuat nsx ");
			sql.append(" WHERE 1=1");
			sql.append(" AND nsx.isDelete = false ");

			if (searchString != null && searchString.length() > 0) {
				Map<String, String> dataSearch = common.splitRequestParamsFromURL(searchString);
                SDT = dataSearch.get("SDT");
                if(SDT!=null) {
                	sql.append("AND nsx.soDT = :SDT");
                }
				tenNhaSX = dataSearch.get("tenNhaSX");
				if (tenNhaSX != null) {
					sql.append(" AND nsx.tenNhaSX = :tenNhaSX ");
				}
			}
			if (sortData != null && sortData.length() > 0) {
				sql.append(" ORDER BY ").append(common.convertSortDataWithAlias(sortData, "nsx"));
			}
			TypedQuery<NhaSanXuat> ressult = entityManager.createQuery(sql.toString(), NhaSanXuat.class);

			if (tenNhaSX != null) {
				ressult.setParameter("tenNhaSX", tenNhaSX);
			}
			if(SDT!=null) {
				ressult.setParameter("SDT", SDT);
			}
			if (pageable != null) {
				nhaSanXuats = ressult.setFirstResult((int) pageable.getOffset())
						.setMaxResults(pageable.getPageSize()).getResultList();
			} else {
				nhaSanXuats = ressult.getResultList();
			}

			return nhaSanXuats;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Long totalInfoNhaSanXuat(String searchString) {
		try {
			String tenNhaSX = null;
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT COUNT(nsx) ");
			sql.append(" FROM NhaSanXuat nsx ");
			sql.append(" WHERE 1=1");
			sql.append(" AND nsx.isDelete = false ");
			if (searchString != null && searchString.length() > 0) {
				Map<String, String> dataSearch = common.splitRequestParamsFromURL(searchString);
				tenNhaSX = dataSearch.get("tenNhaSX");
				if (tenNhaSX != null) {
					sql.append(" AND nsx.tenNhaSX = :tenNhaSX ");
				}
			}
			TypedQuery<Long> ressult = entityManager.createQuery(sql.toString(), Long.class);

			if (tenNhaSX != null) {
				ressult.setParameter("tenNhaSX", tenNhaSX);
			}
			return ressult.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
