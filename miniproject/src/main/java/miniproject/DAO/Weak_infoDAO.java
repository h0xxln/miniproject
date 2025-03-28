package miniproject.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import miniproject.DTO.Weak_infoDTO;
import miniproject.Mapper.Weak_info_mapper;

@Repository("Weak_infoDAO")
public class Weak_infoDAO implements Weak_info_mapper{
	
	@Resource(name="template")
	public SqlSessionTemplate weak_st;
	
	@Override
	public List<Weak_infoDTO>weakInfo_select() {
		List<Weak_infoDTO> weak_infoList = this.weak_st.selectList("weakInfo_select");
	
		return weak_infoList;
	}

	public List<Weak_infoDTO> weekTails_select(String t_name) {

		List<Weak_infoDTO> week_tailsList = this.weak_st.selectList("weekTails_select",t_name);
		return week_tailsList;
	}
}
