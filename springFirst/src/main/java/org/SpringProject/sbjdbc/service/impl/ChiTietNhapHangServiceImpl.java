package org.SpringProject.sbjdbc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.SpringProject.sbjdbc.DAO.ChiTietNhapHangDAO;
import org.SpringProject.sbjdbc.dto.ChiTietNhapHangDto;
import org.SpringProject.sbjdbc.dto.SanPhamNhapDto;
import org.SpringProject.sbjdbc.entity.ChiTietNhapHang;
import org.SpringProject.sbjdbc.repository.ChiTietNhapHangRepository;
import org.SpringProject.sbjdbc.service.ChiTietNhapHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChiTietNhapHangServiceImpl implements ChiTietNhapHangService {
	@Autowired
	private ChiTietNhapHangRepository  ChiTietNhapHangRepository;	
	@Autowired
	private ChiTietNhapHangDAO chiTietNhapHangDAO;
	@Override
    public Map<String, Object>  saveChiTietNhapHang(ChiTietNhapHangDto ChiTietNhapHangDTO) {
    	Map<String, Object > result = new HashMap<String, Object>();
    	try {
    		List<SanPhamNhapDto> listSp = ChiTietNhapHangDTO.getListSanPhams();
    		List<ChiTietNhapHang> listNhapHang = new ArrayList<>();
    		if(listSp != null && listSp.size() > 0) {
    			for(SanPhamNhapDto sp : listSp) {
    				ChiTietNhapHang chiTiet = new ChiTietNhapHang();
    				chiTiet.setIdSanPham(sp.getSanPham().getId());
    				chiTiet.setIdUser(ChiTietNhapHangDTO.getUser().getId());
    				chiTiet.setSoLuong(sp.getSoLuong());
    				chiTiet.setTongTien(sp.getTongTien());
    				chiTiet.setThoiGianNhap(sp.getThoiGianNhap());
    				listNhapHang.add(chiTiet);
    			}
    		}
    		result.put("result",ChiTietNhapHangRepository.saveAll(listNhapHang));
    		return result;
    	    }
    	 catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	    }
    }
	@Override
	public Map<String, Object>  getAllChiTietNhapHang(String search, Integer page, Integer pageSize) {
    	Map<String, Object > result = new HashMap<String, Object>();
    	Map<String, Object> paginationDetail = new HashMap<String, Object>();
    	try {
    		Pageable pageable = null;
    		if(page!= null && pageSize!=null){
    		   pageable = PageRequest.of(page - 1, pageSize);
    		   paginationDetail.put("page", page);
    		   paginationDetail.put("pageSize", pageSize);
    		   paginationDetail.put("totalPage", chiTietNhapHangDAO.totalInfoCTNH(search) );
    		   paginationDetail.put("totalPageOneTime", chiTietNhapHangDAO.totalDsDaCoNguoiMua(search) );
    		   paginationDetail.put("totalPageNoOnce", chiTietNhapHangDAO.totalDSChuaNguoiMua(search) );
    		   paginationDetail.put("totalPageSUM", chiTietNhapHangDAO.totalDSTongTienvsSoLuong(search) );
    		  }
    		result.put("result", chiTietNhapHangDAO.infoChiTietNhapHang(search, pageable, null));
    		result.put("ds mat hang chua co nguoi mua", chiTietNhapHangDAO.dsMatHangChuaCoNguoiMua(search, pageable, null));
    		result.put("ds mat hang da co 1 nguoi mua", chiTietNhapHangDAO.dsMatHangDaCoNguoiMua(search, pageable, null));
    		result.put("ds mat hang da co 2 nguoi mua tro len", chiTietNhapHangDAO.dsMatHangCoNhieuNguoiMua(search, pageable, null));
    		result.put("ds cac nguoi mua co tong tien & tong sl", chiTietNhapHangDAO.dsNguoiMuaVsTongTienVaTongSoLuong(search, pageable, null));
		    result.put("pagination Total", paginationDetail );
		    return result;
    	    }
    	catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	    }
    }
	@Override
	public Map<String, Object>  getChiTietNhapHangById(Long id) {
    	Map<String, Object > result = new HashMap<String, Object>();
    	try {
    		result.put("result", ChiTietNhapHangRepository.findById(id));
    		return result;
    	    }
    	catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	    }
	}
    @Override
	public Map<String, Object> updateChiTietNhapHang(ChiTietNhapHang ChiTietNhapHang) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			ChiTietNhapHang chiTietNhapHang = ChiTietNhapHangRepository.findByIdUserAndIdSanPham(ChiTietNhapHang.getIdUser(), ChiTietNhapHang.getIdSanPham());
			//if(chiTietNhapHang.isPresent()) {
			  chiTietNhapHang.setSoLuong(ChiTietNhapHang.getSoLuong());
			  chiTietNhapHang.setTongTien(ChiTietNhapHang.getTongTien());
			  result.put("result", ChiTietNhapHang);
			return result;
			//}else {
			   //return result; 
			//}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
