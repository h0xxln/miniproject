package miniproject.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import miniproject.DTO.Sign_DTO;
import miniproject.Mapper.Sign_mapper;

@Repository("Sign_DAO")
public class Sign_DAO  implements Sign_mapper{
	
	
	@Resource(name="template")
	public SqlSessionTemplate sign_st;
	
	@Override
	public int check_email(String m_email) {	//이메일 중복체크
		int result = this.sign_st.selectOne("check_email",m_email);
		
		return result;
	}
	
	@Override
	public int signup_insert(Sign_DTO dto){		//회원가입 
		int result = this.sign_st.insert("signup_insert", dto);
		return result;
	}
	
	@Override
	public List<Sign_DTO> login_select(Sign_DTO dto) { 	//로그인
		//System.out.println(dto.getM_email());
		List<Sign_DTO> loginList = this.sign_st.selectList("login_select",dto);
		
		return loginList;
	}
	
	@Override
	public int delete_member(Sign_DTO dto){ 	//회원 삭제
		int member_deleteResult = this.sign_st.delete("delete_member",dto); 
		return member_deleteResult;
	}
	
	@Override
	public Sign_DTO search_email(String m_name, String m_number) {	//이메일 찾기
		Map<String, String> searchId = new HashMap<String, String>();
		searchId.put("m_name", m_name);
		searchId.put("m_number", m_number);
		
		Sign_DTO result = this.sign_st.selectOne("search_email",searchId);
		System.out.println(result);
		return result;
	}
	
	@Override
	public int search_pass(String m_email, String m_number) {	//비밀번호 찾기
		Map<String, String> searchPass = new HashMap<String, String>();
		searchPass.put("m_email", m_email);
		searchPass.put("m_number", m_number);
		
		int result = this.sign_st.selectOne("search_pass",searchPass);
		//System.out.println(result);
		return result;
	}
	
	
	
	
}
