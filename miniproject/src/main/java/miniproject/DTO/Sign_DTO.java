package miniproject.DTO;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository("Sign_DTO")
public class Sign_DTO {
	int m_idx; //자동 증가값
    String m_email;        // 이메일
    String m_pass;         // 비밀번호 (md5 사용)
    String m_name;         // 이름
    String m_number;       // 전화번호
    String m_age;          // 나이 확인 (ENUM 'Y')
    String m_terms;        // 이용약관 동의 (ENUM 'Y')
    String m_privacy;      // 개인정보 수집 및 이용 동의 (ENUM 'Y')
    String m_marketing;    // 마케팅 수신 동의 여부 (ENUM 'Y'/'N')
    String m_date;         // 가입 날짜 (TIMESTAMP) - 기본값 CURRENT_TIMESTAMP
    
    
    //카카오 로그인 
    String kakao_id;	   // 카카오 아이디
    String kakao_nicknm;   // 카카오 닉네임
    String code;		   // 일반회원인지, 카카오회원인지 구분
    String part; 		   // sign_mapper.xml에서 select시 구분하기 위함(database에 삽입되는 값이 아님)
}
