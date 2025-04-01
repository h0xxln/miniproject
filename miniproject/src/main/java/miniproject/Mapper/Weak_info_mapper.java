package miniproject.Mapper;

import java.util.List;



import miniproject.DTO.Weak_infoDTO;



//함수는 동사로 시작
public interface Weak_info_mapper { 

	public List<Weak_infoDTO> weakInfo_select();
	public List<Weak_infoDTO> weekTails_select(String tidx) ;
}
