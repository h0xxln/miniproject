package miniproject.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import miniproject.DTO.Web_infoDTO;
import miniproject.Mapper.Web_info_mapper;

@Repository("Web_infoDAO")
public class Web_infoDAO implements Web_info_mapper{

	@Resource(name="template")
	public SqlSessionTemplate webinfo_st;
	
	@Override
	public List<Web_infoDTO> webInfo_select(Web_infoDTO webdto) {
		List<Web_infoDTO> web_infoList = this.webinfo_st.selectList("webInfo_select",webdto);
		return web_infoList;
	}
	
	 
	
}
