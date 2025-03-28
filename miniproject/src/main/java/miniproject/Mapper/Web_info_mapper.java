package miniproject.Mapper;

import java.util.List;


import miniproject.DTO.Md_choiceDTO;
import miniproject.DTO.Sign_DTO;
import miniproject.DTO.Web_infoDTO;


//함수는 동사로 시작
public interface Web_info_mapper { 

	public List<Web_infoDTO> webInfo_select();
	
}
