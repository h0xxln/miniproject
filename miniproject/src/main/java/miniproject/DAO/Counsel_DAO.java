package miniproject.DAO;

 
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import miniproject.Mapper.Counsel_mapper;

@Repository("Counsel_DAO")
public class Counsel_DAO implements Counsel_mapper{
	
	@Resource(name="template")
	public SqlSessionTemplate cons_st;
	
	@Override
	public int apply_counsel(Map<String, String> counselData) {
		
		int result = this.cons_st.insert("apply_counsel",counselData);
		
		return result;
	}
	
}
