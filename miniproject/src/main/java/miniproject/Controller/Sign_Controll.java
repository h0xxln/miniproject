package miniproject.Controller;

import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
public class Sign_Controll extends Md5_Model {
    PrintWriter pw = null;
    String md5_mpass = ""; 

    @Resource(name = "Sign_DAO")
    private Sign_DAO signDAO;

    // 비밀번호 변경 쿼리 수행
    @PostMapping("/realty/update_pass.do")
    public String update_pass(
            @RequestParam("m_email") String m_email,
            @RequestParam("m_pass") String m_pass,
            HttpServletResponse res) {
        
        String msg = "";
        try {
            this.pw = res.getWriter();
            this.md5_mpass = md5(m_pass);
            Integer result = this.signDAO.update_pass(m_email, this.md5_mpass);
            if (result > 0) {
                msg = "ok";
            } else {
                msg = "no";
            }
            this.pw.print(msg); 
        } catch (Exception e) {
            System.out.println("비밀번호 변경 오류 발생: " + e);
        } finally {
                this.pw.close(); // 스트림 닫기
        }
        return null;
    }

    // 비밀번호 변경 페이지 출력
    @GetMapping("/realty/search_mypass.do")
    public String search_mypass(Sign_DTO dto) {
        return "/realty/search_mypass";
    }

    // 비밀번호 찾기
    @PostMapping("/realty/search_pass.do")
    public String search_pass(Sign_DTO dto, HttpServletResponse res, HttpServletRequest request, HttpSession session) {
        String msg = "";
        try {
            this.pw = res.getWriter();
            session = request.getSession();
            String result = this.signDAO.search_pass(dto.getM_email(), dto.getM_number());
            session.setAttribute("m_email", result);
            if (result != null) {
                msg = "ok";
            } else {
                msg = "no";
            }
            this.pw.print(msg); 
        } catch (Exception e) {
            System.out.println("비밀번호 찾기 오류 발생: " + e);
        } finally {
                this.pw.close(); // 스트림 닫기
        }
        return null;
    }

    // 회원 가입시 아이디 중복체크
    @GetMapping("/realty/email_check.do") 
    public String email_check(@RequestParam("m_email") String m_email, HttpServletResponse res) {
        String msg = "";
        try {
            this.pw = res.getWriter();
            int result = this.signDAO.check_email(m_email);
            if (result > 0) {
                msg = "no";
            } else {
                msg = "ok";
            }
            this.pw.print(msg);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
                this.pw.close(); // 스트림 닫기
        }
        return null;
    }

    // 이메일 찾기
    @PostMapping("/realty/search_email.do")
    public String search_email(Model email_msg, Sign_DTO dto) {
        try {
            Sign_DTO data = this.signDAO.search_email(dto.getM_name(), dto.getM_number());
            String msg = "";
            if (data == null) {
                msg = "가입하신 정보는 확인 되지 않습니다";
            } else {
                msg = data.getM_email();
            }
            email_msg.addAttribute("msg", msg);
        } catch (Exception e) {
            System.out.println("이메일 찾기시 오류 발생 : "+e);
        }
        return "/realty/search_myinfo";
    }

    // 회원 삭제
    @PostMapping("/realty/delete_member.do")
    public String delete_member(Sign_DTO dto, HttpServletResponse res) {
        res.setContentType("text/html; charset=UTF-8");
        int result = this.signDAO.delete_member(dto);
        try {
            this.pw = res.getWriter();
            if (result > 0) {
                this.pw.println("<script>"
                        + "alert('정상적으로 계정이 삭제 되었습니다.');"
                        + "location.href='/realty/login.jsp';"
                        + "</script>");
            } else {
                this.pw.println("<script>"
                        + "alert('계정을 삭제 하지 못하였습니다. 올바른 정보를 입력하세요.');"
                        + "history.go(-1);"
                        + "</script>");
            }
        } catch (Exception e) {
            System.out.println("회원 삭제시 오류 발생 :" + e);
        } finally {
                this.pw.close(); // 스트림 닫기
        }
        return null;
    }

    // 회원 로그인
    @PostMapping("/realty/loginok.do")
    public String loginok(Sign_DTO dto, HttpServletResponse res, HttpSession session, HttpServletRequest rq) {
        res.setContentType("text/html; charset=UTF-8");
        try {
        	 session = rq.getSession();
            this.md5_mpass = this.md5(dto.getM_pass()); // 패스워드 암호화
            dto.setM_pass(md5_mpass); // 암호화된 패스워드로 DTO 설정
            List<Sign_DTO> loginList = this.signDAO.login_select(dto);
            System.out.println("loginList: " + loginList);
            session.setAttribute("login", loginList);
            
            this.pw = res.getWriter();
            if (loginList != null && !loginList.isEmpty()) {
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
        } catch (Exception e) {
            System.out.println("회원 로그인 오류" + e);
        } finally {
               this.pw.close(); // 스트림 닫기
        }
        return null;
    }

    // 회원가입
    @PostMapping("/realty/member_joinok.do")
    public String member_joinok(Sign_DTO dto, HttpServletResponse res) {
        res.setContentType("text/html; charset=UTF-8");
        try {
        	this.pw = res.getWriter();
            this.md5_mpass = this.md5(dto.getM_pass()); // 패스워드 암호화
            dto.setM_pass(md5_mpass); // 암호화된 패스워드로 DTO 설정
            if (dto.getM_marketing() == null) {
                dto.setM_marketing("N");
            }
            int result = this.signDAO.signup_insert(dto);
            System.out.println(result);
            if (result > 0) {
                this.pw.println("<script>"
                        + "alert('정상적으로 계정이 생성 되었습니다.');"
                        + "location.href='/realty/index.do';"
                        + "</script>");
            } else {
                this.pw.println("<script>"
                        + "alert('계정을 생성하지 못하였습니다.');"
                        + "history.go(-1);"
                        + "</script>");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
           this.pw.close();
            
        }
        return "/realty/login";
    }
}
