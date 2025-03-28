package miniproject.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import miniproject.DTO.Md_choiceDTO;
import miniproject.Mapper.Md_choice_mapper;

@Repository("Md_choiceDAO")
public class Md_choiceDAO implements Md_choice_mapper {
	@Resource(name="template")
	public SqlSessionTemplate md_st;
	
	@Override
	public List<Md_choiceDTO> mdchoice_select() {
		List<Md_choiceDTO> md_choiceList = this.md_st.selectList("mdchoice_select");
		
		return md_choiceList;
	}
}
