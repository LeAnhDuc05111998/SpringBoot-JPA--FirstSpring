package org.SpringProject.sbjdbc.dto;

import java.util.List;
import org.SpringProject.sbjdbc.entity.User;
import lombok.Data;

@Data
public class ChiTietNhapHangDto {

	private User user;

	private List<SanPhamNhapDto> listSanPhams;
}
