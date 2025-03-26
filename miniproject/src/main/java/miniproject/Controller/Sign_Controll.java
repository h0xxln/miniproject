package miniproject.Controller;

import java.io.PrintWriter;
import java.util.List;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import Model.Md5_Model;
import miniproject.DAO.Sign_DAO;
import miniproject.DTO.Sign_DTO;

@Controller
public class Sign_Controll extends Md5_Model{
	PrintWriter pw = null;
	String md5_mpass = ""; 

	@Resource(name = "Sign_DAO")
	private Sign_DAO signDAO;
	
	
	//비밀번호 찾기
	@PostMapping("/realty/search_pass.do")
	public String search_pass(Sign_DTO dto ,HttpServletResponse res) {
		res.setContentType("text/html; charset=UTF-8");

		try {
			this.pw = res.getWriter();
	        int result = this.signDAO.search_pass(dto.getM_email(), dto.getM_number());
	        System.out.println(result);
	        if (result > 0) {
	            this.pw.print("<script>"
	                    + "if (confirm('입력하신 정보와 일치하는 계정이 있습니다. 비밀번호를 변경하시겠습니까?')) {"
	                    + "    location.href='/realty/search_mypass.jsp';"
	                    + "} else {"
	                    + "    history.go(-1);"
	                    + "}"
	                    + "</script>");
	        } else {
	            this.pw.print("<script>"
	                    + "alert('입력하신 정보와 일치하는 계정이 없습니다.');"
	                    + "history.go(-1);"
	                    + "</script>");
	        }

	    } catch (Exception e) {
	        System.out.println("비밀번호 찾기 오류 발생: " + e);
	    }
		
		return null;
	}
	
	
	//이메일 찾기
	@PostMapping("/realty/search_email.do")
	public String search_email(Model email_msg, Sign_DTO dto){
		
		try {
			Sign_DTO data = this.signDAO.search_email(dto.getM_name(), dto.getM_number());
			String msg = "";
			if(data == null) {
				msg = "가입하신 정보는 확인 되지 않습니다";
			}
			else{
				msg = data.getM_email();
				System.out.println(msg);
			}
			email_msg.addAttribute("msg", msg);
			
		} 
		catch (Exception e) {
			System.out.println("이메일 찾기시 오류 발생 : "+e);
		}
		
		return "/realty/search_myinfo";
	}

	
	
	//회원 삭제.
	@PostMapping("/realty/delete_member.do")
	public String delete_member(Sign_DTO dto, HttpServletResponse res){
		res.setContentType("text/html; charset=UTF-8");
		int result = this.signDAO.delete_member(dto);

		try {
			this.pw = res.getWriter();
			
			if(result > 0) {
				this.pw.println("<script>"
						+ "alert('정상적으로 계정이 삭제 되었습니다.');"
						+ "location.href='/realty/login.jsp';"
						+ "</script>");
			}
			else {
				this.pw.println("<script>"
						+ "alert('계정을 삭제 하지 못하였습니다. 올바른 정보를 입력하세요.');"
						+ "history.go(-1);"
						+ "</script>");
			}
			
		} 
		catch (Exception e) {
			System.out.println("회원 삭제시 오류 발생 :" + e);
		}
		finally {
			this.pw.close();			
		}
		return null;
	}
	
	//회원 가입시 아이디 중복체크
	@GetMapping("/realty/email_check.do") 
	public String email_check(@RequestParam("m_email") String m_email, 
			HttpServletResponse res) {
	
		String msg = "";
		try {
			this.pw = res.getWriter();
			int result = this.signDAO.check_email(m_email);
			System.out.println(result);
			if(result > 0) {
				msg = "no";
			}
			else {
				msg = "ok";
			}
			this.pw.print(msg);
			this.pw.close();	
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	//회원 로그인
	@PostMapping("/realty/loginok.do")
	public String loginok(Sign_DTO dto, HttpServletResponse res, HttpSession hs) {

		res.setContentType("text/html; charset=UTF-8");
		// 로그인 정보를 가져오기
		List<Sign_DTO> loginList = this.signDAO.login_select(dto);
		
		try {	
			this.md5_mpass = this.md5(dto.getM_pass()); // dto에 저장된 패스워드를 md5모델을 이용하여 암호화
			dto.setM_pass(md5_mpass); //md5로 패스워드 변경후 dto 전달
			this.pw = res.getWriter();
			
			if (loginList != null && !loginList.isEmpty()) {
				//hs.setAttribute("m_name", dto.getM_name());
				this.pw.print("<script>"
							+ "alert('로그인이 정상적으로 완료 되었습니다.');"
							+ "location.href='/realty/index.do';"
							+ "</script>");
				this.pw.flush();
				return "/realty/index"; // 메인 페이지로 이동
				
			} else {
				this.pw.print("<script>"
							+ "alert('로그인 실패 하였습니다. 이메일 또는 비밀번호를 확인하세요.');"
							+ "history.go(-1);"
							+ "</script>");
				this.pw.flush();
				return "/realty/login"; // 로그인 실패 -> 로그인 페이지로 다시 이동
			}
		} 
		catch (Exception e) {
			System.out.println("회원 로그인 오류" + e);
		}
		finally {
			this.pw.close();
		}

		return null;
	}

	//회원가입
	@PostMapping("/realty/member_joinok.do")
	public String member_joinok(Sign_DTO dto, HttpServletResponse res) {
		
		res.setContentType("text/html; charset=UTF-8");
		
		try {
			this.md5_mpass = this.md5(dto.getM_pass());	 // md5 모델을 가쟈외
			dto.setM_pass(md5_mpass);	//md5로 패스워드 변경후 dto 전달

			if(dto.getM_marketing() == null) {
				dto.setM_marketing("N");
			}
			
			int result = this.signDAO.signup_insert(dto);
			
			if(result > 0) {
				this.pw.println("<script>"
						+ "alert('정상적으로 계정이 생성 되었습니다.');"
						+ "location.href='/realty/index.do';"
						+ "</script>");
			}
			else {
				this.pw.println("<script>"
						+ "alert('계정을 생성하지 못하였습니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}

		} 
		catch (Exception e) {
			System.out.println(e);
		}
		finally {			
			this.pw.close();
		}
		return "/realty/login";
	}
	
	
	
}
