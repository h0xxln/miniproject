
package miniproject.Controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import miniproject.DAO.Counsel_DAO;


@Controller
public class Counsel_Controller {
	
	PrintWriter pw = null;
		
	@Resource(name="Counsel_DAO")
	private Counsel_DAO cdao;

	//counsel.do 접속시 counsel.jsp 맵핑
	@GetMapping("/realty/counsel.do")
	public String counsel() {
		
		return null;
	}
	
	@PostMapping("/realty/apply_counsel.do")
	public String apply_counsel(
		HttpServletResponse res,
		@RequestParam("c_name") String c_name,
		@RequestParam("c_email") String c_email,
		@RequestParam("c_number") String c_number,
		@RequestParam(value = "c_rentype", required = false) ArrayList<String> rentype,
		@RequestParam(value = "c_livetype", required = false) ArrayList<String> livetype,
		@RequestParam("c_counseltime") String c_counseltime,
		@RequestParam("c_content") String c_content
	) {
		res.setContentType("text/html;charset=utf-8");

		// 체크박스 값 처리 (ArrayList를 문자열로 변환)
		String c_rentype = String.join(",", rentype);
		String c_livetype = String.join(",", livetype);
		System.out.println(c_rentype+ "counsel 컨트롤러임" +c_livetype);

		Map<String, String> counselData = new HashMap<String, String>();
		counselData.put("c_name", c_name);
		counselData.put("c_email", c_email);
		counselData.put("c_number", c_number);
		counselData.put("c_rentype", c_rentype);
		counselData.put("c_livetype", c_livetype);
		counselData.put("c_counseltime", c_counseltime);
		counselData.put("c_content", c_content); 
		
		// 데이터 저장 (DAO 호출)
		int result = this.cdao.apply_counsel(counselData);
		System.out.println("controller 결과 : "+result);
		try {
			PrintWriter pw = res.getWriter();
			
			if (result > 0) {
				pw.print("<script>"
						+ "alert('담당자가 확인 후 해당 상담일시에 맞춰서 연락 드립니다.');"
						+ "location.href='/realty/index.do';"
						+ "</script>");
			} 
			else {
				pw.print("<script>alert('상담 신청에 실패했습니다.'); history.go(-1);</script>");
			}
			
		} catch (Exception e) {
			System.out.println("상담신청 오류: " + e);
		}

		return null;
	}

}
