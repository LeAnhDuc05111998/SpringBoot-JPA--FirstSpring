package org.SpringProject.sbjdbc.DAO;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.SpringProject.sbjdbc.common.common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class ChiTietNhapHangDAO {
	@Autowired
	private EntityManager entityManager;

	public List<Object> infoChiTietNhapHang(String searchString, Pageable pageable, String sortData) {
		List<Object> ChiTietSP = new ArrayList<>();
		try {
			String ngayNhapTu = null;
			String ngayNhapDen = null;
			String thoiGianNhap = null;
			StringBuilder sql = new StringBuilder();
            //querry chinh					
			  sql.append(" SELECT NEW MAP( "); 
			  sql.append(" us.hoTen as hoTen, ");
			  sql.append(" sp.tenSP as tenSP, "); 
			  sql.append(" ctnh.soLuong as soLuong, ");
			  sql.append(" ctnh.tongTien as tongtien, ");
			  sql.append(" ctnh.thoiGianNhap as thoiGianNhap "); 
			  sql.append(" ) ");
			  sql.append(" FROM ChiTietNhapHang ctnh ");
			  sql.append(" LEFT JOIN User as us on us.id=ctnh.idUser ");
			  sql.append(" LEFT JOIN SanPham as sp on sp.id=ctnh.idSanPham ");
			  sql.append(" WHERE 1=1 ");
			  	
			if (searchString != null && searchString.length() > 0) { 
				  Map<String, String> dataSearch = common.splitRequestParamsFromURL(searchString);  
			//search theo 1 time 
				  thoiGianNhap = dataSearch.get("thoiGianNhap");
			if (thoiGianNhap != null) { 
			      sql.append(" AND ctnh.thoiGianNhap = :thoiGianNhap "); 
			   }  
			//search trong khoang time
			      ngayNhapTu = dataSearch.get("ngayNhapTu"); 
			if (ngayNhapTu!= null) { 
				  sql.append(" AND ctnh.thoiGianNhap > :ngayNhapTu"); 
		       } 
			      ngayNhapDen = dataSearch.get("ngayNhapDen"); 
			if (ngayNhapDen != null) {
			      sql.append(" AND ctnh.thoiGianNhap < :ngayNhapDen");
			   } 
			}		 
			//sql.append(" GROUP BY (tenSP, hoTen, soLuong, tongtien, thoiGianNhap)");
			if (sortData != null && sortData.length() > 0) {
				sql.append(" ORDER BY ").append(common.convertSortDataWithAlias(sortData, "nsx"));
			}
			TypedQuery<Object> result = entityManager.createQuery(sql.toString(), Object.class);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			if (thoiGianNhap != null) {
				String date = thoiGianNhap;
				LocalDate localDate = LocalDate.parse(date, formatter);
				result.setParameter("thoiGianNhap", localDate);
			}
			if (ngayNhapDen != null) {
				String date = ngayNhapDen;
				LocalDate localDate = LocalDate.parse(date, formatter);
				result.setParameter("ngayNhapDen", localDate);
			}
			if (ngayNhapTu != null) {
				String date = ngayNhapTu;
				LocalDate localDate = LocalDate.parse(date, formatter);
				result.setParameter("ngayNhapTu", localDate);
			}
			if (pageable != null) {
				ChiTietSP = result.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize())
						.getResultList();
			} else {
				ChiTietSP = result.getResultList();
			}
			return ChiTietSP;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
    //ds chua co ng mua
	public List<Object> dsMatHangChuaCoNguoiMua(String searchString, Pageable pageable, String sortData) {
		List<Object> ChiTietSP1 = new ArrayList<>();
		try {
			String thoiGianNhap = null;
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT New Map( ");
			sql.append(" sp.tenSP as tenSP, ");
			sql.append(" us.hoTen as hoTen ");
			sql.append(" ) ");
			sql.append(" FROM ChiTietNhapHang ctnh ");
			sql.append(" FULL JOIN User us on us.id = ctnh.idUser ");
			sql.append(" FULL JOIN SanPham sp on sp.id = ctnh.idSanPham ");
			sql.append(" WHERE 1=1 ");
			sql.append(" AND soLuong Is null ");
			sql.append(" AND us.id Is null ");

			if (searchString != null && searchString.length() > 0) {
				Map<String, String> dataSearch = common.splitRequestParamsFromURL(searchString);	
				thoiGianNhap = dataSearch.get("thoiGianNhap");
			if (thoiGianNhap != null) {
					sql.append(" AND ctnh.thoiGianNhap = :thoiGianNhap ");
				}
			}
			sql.append(" GROUP BY (tenSP, hoTen, soLuong, tongtien, thoiGianNhap)");
			if (sortData != null && sortData.length() > 0) {
				sql.append(" ORDER BY ").append(common.convertSortDataWithAlias(sortData, "nsx"));
			}
			TypedQuery<Object> result = entityManager.createQuery(sql.toString(), Object.class);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			if (thoiGianNhap != null) {
				String date = thoiGianNhap;
				LocalDate localDate = LocalDate.parse(date, formatter);
				result.setParameter("thoiGianNhap", localDate);
			}
			if (pageable != null) {
				ChiTietSP1 = result.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize())
						.getResultList();
			} else {
				ChiTietSP1 = result.getResultList();
			}
			return ChiTietSP1;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//ds da co 1 ng mua
	public List<Object> dsMatHangDaCoNguoiMua(String searchString, Pageable pageable, String sortData) {
		List<Object> ChiTietSP2 = new ArrayList<>();
		try {
			String thoiGianNhap = null;
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT New Map( ");
			sql.append(" sp.tenSP as tenSP, ");
			sql.append(" sp.nguonGoc as nguonGoc ");
			sql.append(" ) ");
			sql.append(" FROM ChiTietNhapHang ctnh ");
			sql.append(" INNER JOIN SanPham sp on ctnh.idSanPham = sp.id ");
			if (searchString != null && searchString.length() > 0) {
				Map<String, String> dataSearch = common.splitRequestParamsFromURL(searchString);	
				thoiGianNhap = dataSearch.get("thoiGianNhap");
				if (thoiGianNhap != null) {
					sql.append(" AND ctnh.thoiGianNhap = :thoiGianNhap ");
				}
			}
			sql.append(" GROUP BY (tenSP, nguonGoc)");
			if (sortData != null && sortData.length() > 0) {
				sql.append(" ORDER BY ").append(common.convertSortDataWithAlias(sortData, "nsx"));
			}
            
			TypedQuery<Object> result = entityManager.createQuery(sql.toString(), Object.class);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			if (thoiGianNhap != null) {
				String date = thoiGianNhap;
				LocalDate localDate = LocalDate.parse(date, formatter);
				result.setParameter("thoiGianNhap", localDate);
			}
			if (pageable != null) {
				ChiTietSP2 = result.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize())
						.getResultList();
			} else {
				ChiTietSP2 = result.getResultList();
			}

			return ChiTietSP2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//ds 2 ng mua >
	public List<Object> dsMatHangCoNhieuNguoiMua(String searchString, Pageable pageable, String SortData) {
		List<Object> ChiTietSP3 = new ArrayList<Object>();
		try {    
			    String nhapSoLanMua = null;
				StringBuilder sql = new StringBuilder();	
				sql.append(" SELECT NEW MAP( ");
				sql.append(" sp.tenSP as tenSP, ");
				sql.append(" sp.nguonGoc as nguonGoc, ");
				sql.append(" sp.gia as gia ");
				sql.append(" ) ");
				sql.append(" FROM ChiTietNhapHang ctnh ");
				sql.append(" INNER JOIN SanPham sp on sp.id = ctnh.idSanPham ");
				sql.append(" GROUP BY sp.tenSP, sp.nguonGoc, sp.gia ");
				//sql.append(" Having Count(tenSP) >1 ");
				if (searchString != null && searchString.length() > 0) {
					Map<String, String> dataSearch = common.splitRequestParamsFromURL(searchString);
					nhapSoLanMua = dataSearch.get("nhapSoLanMua");
					if(nhapSoLanMua!=null) {
						sql.append(" Having Count(tenSP)> :nhapSoLanMua ");
					}
				}
		        if(SortData!= null && SortData.length() >0 ) {
		          sql.append("ORDER BY ").append(common.convertSortDataWithAlias(SortData,"nsx"));
		        }
		        TypedQuery<Object> result = entityManager.createQuery(sql.toString(), Object.class);
		        if(nhapSoLanMua!=null) {
		        	Long num = Long.valueOf(nhapSoLanMua);
		            result.setParameter("nhapSoLanMua", num);
		        }
				if (pageable != null) {
					ChiTietSP3 = result.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize())
							.getResultList();
				} else {
					ChiTietSP3 = result.getResultList();
				}
		}
		catch(Exception e) {
		    e.printStackTrace();
		    return null;
		}
	return ChiTietSP3;
	}
	//ds sum tt & sl 	
    public List<Object> dsNguoiMuaVsTongTienVaTongSoLuong(String searchString, Pageable pageable, String SortData) { 
	   List<Object> ChiTietSP5 = new ArrayList<Object>(); 
	   try { 
		  String nhapHoTen = null;
		  String tongTienMin = null;
		  String tongTienMax = null;
		  String nhapSanPham = null;
		  String nhapSoLuong = null;
		  StringBuilder sql = new StringBuilder();
	  
	  sql.append(" SELECT NEW MAP( "); 
	  sql.append(" us.hoTen as hoTen, ");
	  sql.append(" sp.tenSP as tenSP, ");
	  sql.append(" SUM(ctnh.soLuong) as soLuong, ");
	  sql.append(" SUM(ctnh.tongTien) as tongtien ");
	  sql.append(" ) ");
	  sql.append(" FROM ChiTietNhapHang ctnh ");
	  sql.append(" INNER JOIN User as us on us.id=ctnh.idUser ");
	  sql.append(" INNER JOIN SanPham as sp on sp.id=ctnh.idSanPham ");
	  if(searchString != null && searchString.length() > 0) {
		  Map<String, String> dataSearch = common.splitRequestParamsFromURL(searchString);
	      nhapHoTen = dataSearch.get("nhapHoTen");
	      if(nhapHoTen!= null) {
		     sql.append(" AND us.hoTen = :nhapHoTen ");
	      }
	      nhapSanPham = dataSearch.get("nhapSanPham");
	      if(nhapSanPham!= null) {
		          sql.append(" AND sp.tenSP = :nhapSanPham ");
	      }
	              sql.append(" GROUP BY(us.hoTen, sp.tenSP) ");
	         tongTienMin = dataSearch.get("tongTienMin");
		      if(tongTienMin!=null) {
		    	  sql.append(" Having SUM(ctnh.tongTien) > :tongTienMin ");	    	 
		      }
		     tongTienMax = dataSearch.get("tongTienMax");
		      if(tongTienMax!=null && tongTienMin!=null) {
		    	  sql.append(" AND SUM(ctnh.tongTien) < :tongTienMax ");
		      }
		     nhapSoLuong = dataSearch.get("nhapSoLuong");
		      if(nhapSoLuong!=null && tongTienMin!=null) {
			      sql.append(" AND SUM(ctnh.soLuong) >= :nhapSoLuong ");
			  }else {
			    if(nhapSoLuong!=null) {
				  sql.append(" Having SUM(ctnh.soLuong) >= :nhapSoLuong ");   
				} 
			  }
	  }else {
	  sql.append(" GROUP BY(us.hoTen, sp.tenSP) "); 
	  }
	  TypedQuery<Object> result = entityManager.createQuery(sql.toString(), Object.class);
	  if(nhapHoTen!= null) {
		  result.setParameter("nhapHoTen", nhapHoTen);
	      }
	  if(nhapSanPham!= null) {
		  result.setParameter("nhapSanPham", nhapSanPham);
	      }
	  if(tongTienMin!= null) {
		  BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(tongTienMin));
		  assertEquals(new BigDecimal(tongTienMin), bigDecimal);
		  result.setParameter("tongTienMin", bigDecimal);
	      }
	  if(tongTienMax!= null) { 
		  BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(tongTienMax));
		  assertEquals(new BigDecimal(tongTienMax), bigDecimal);
		  result.setParameter("tongTienMax", bigDecimal);
	      }
	  if(nhapSoLuong!= null) { 
		  BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(nhapSoLuong));
		  assertEquals(new BigDecimal(nhapSoLuong), bigDecimal);
		  result.setParameter("nhapSoLuong", bigDecimal);
	      }
	  if (pageable != null) {
		    ChiTietSP5 = result.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
	  }else {
			ChiTietSP5 = result.getResultList();
	  }	  
	} 
	  catch(Exception e) {
	      e.printStackTrace(); 
	      return null; 
	  } 
	  return ChiTietSP5;
	}
	// hien thi phan trang ctnh
	public Long totalInfoCTNH(String searchString) {
		try {	
			String detail = null;
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT COUNT(ctnh) ");
			sql.append(" FROM ChiTietNhapHang ctnh ");
			sql.append(" WHERE 1=1 ");
			if (searchString != null && searchString.length() > 0) {
				Map<String, String> dataSearch = common.splitRequestParamsFromURL(searchString);

				detail = dataSearch.get("idUser");
				if (detail != null) {
					sql.append(" AND ctnh.idUser = :idUser ");
				}
			}
			TypedQuery<Long> ressult = entityManager.createQuery(sql.toString(), Long.class);

			if (detail != null) {
				ressult.setParameter("idUser", detail);
			}
			return ressult.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//tt 1 lan
	public Long totalDsDaCoNguoiMua(String searchString) {
		try {	
			String detail = null;
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT COUNT(DISTINCT ctnh.idSanPham) ");
			sql.append(" FROM ChiTietNhapHang ctnh ");
			sql.append(" INNER JOIN SanPham sp on ctnh.idSanPham = sp.id ");
			sql.append(" WHERE 1=1 ");
			if (searchString != null && searchString.length() > 0) {
				Map<String, String> dataSearch = common.splitRequestParamsFromURL(searchString);

				detail = dataSearch.get("idSanPham");
				if (detail != null) {
					sql.append(" AND ctnh.idSanPham = :idSanPham ");
				}
			}
			TypedQuery<Long> ressult = entityManager.createQuery(sql.toString(), Long.class);

			if (detail != null) {
				ressult.setParameter("idSanPham", detail);
			}
			return ressult.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//tt 0 lan
	public Long totalDSChuaNguoiMua(String searchString) {
		try {	
			String detail = null;
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT COUNT(ALL sp.id) ");
			sql.append(" FROM ChiTietNhapHang ctnh ");
			sql.append(" FULL JOIN User us on us.id = ctnh.idUser ");
			sql.append(" FULL JOIN SanPham sp on sp.id = ctnh.idSanPham ");
			sql.append(" WHERE 1=1 ");
			sql.append(" AND soLuong Is null ");
			sql.append(" AND us.id Is null ");
			if (searchString != null && searchString.length() > 0) {
				Map<String, String> dataSearch = common.splitRequestParamsFromURL(searchString);

				detail = dataSearch.get("idUser");
				if (detail != null) {
					sql.append(" AND ctnh.idUser = :idUser ");
				}
			}
			TypedQuery<Long> ressult = entityManager.createQuery(sql.toString(), Long.class);

			if (detail != null) {
				ressult.setParameter("idUser", detail);
			}
			return ressult.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Long totalDSTongTienvsSoLuong(String searchString) {
		try {	
			String detail = null;
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT COUNT(ALL us.id) ");
			sql.append(" FROM ChiTietNhapHang ctnh ");
			sql.append(" INNER JOIN User us on us.id = ctnh.idUser ");
			sql.append(" INNER JOIN SanPham sp on sp.id = ctnh.idSanPham ");
			if (searchString != null && searchString.length() > 0) {
				Map<String, String> dataSearch = common.splitRequestParamsFromURL(searchString);

				detail = dataSearch.get("idUser");
				if (detail != null) {
					sql.append(" AND ctnh.idUser = :idUser ");
				}
			}
			TypedQuery<Long> ressult = entityManager.createQuery(sql.toString(), Long.class);

			if (detail != null) {
				ressult.setParameter("idUser", detail);
			}
			return ressult.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

