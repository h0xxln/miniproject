package miniproject.Mapper;

import java.util.List;

import miniproject.DTO.Sign_DTO;


//회원 관련 mapper
//함수는 동사로 시작
public interface Sign_mapper {
	List<Sign_DTO> login_select(Sign_DTO dto); //로그인 
	public int delete_member(Sign_DTO dto); //회원 삭제
	public int signup_insert(Sign_DTO dto);	//회원 가입 
	Sign_DTO search_email(String m_name, String m_number); //이메일 찾기
	public int check_email(String m_email);// 이메일 중복체크
	public String search_pass(String m_email, String m_number); //패스워드 찾기/변경
	public Integer update_pass(String m_email, String m_pass); //패스워드 변경
}
