package miniproject.Mapper;

import java.util.List;


import miniproject.DTO.Md_choiceDTO;
import miniproject.DTO.Sign_DTO;
import miniproject.DTO.Web_infoDTO;

//카피라이터
//함수는 동사로 시작
public interface Md_choice_mapper {
	List<Md_choiceDTO> mdchoice_select(Md_choiceDTO mddto);
}
