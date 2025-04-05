package miniproject.Controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import miniproject.DAO.Reservation_DAO;
import miniproject.DTO.ReservationDTO;
import miniproject.DTO.Sign_DTO;
import miniproject.DTO.Weak_infoDTO;

@Controller
public class Reservation_Controller {
	
	@Resource(name="Reservation_DAO")
	private Reservation_DAO resDAO;
	
	PrintWriter pw = null;
	
	
	//reservation_list(방문 예약 취소) 
	@PostMapping("/realty/cancel_reslist.do")
	public String cancel_reslist(ReservationDTO resdto , HttpServletResponse res) {
		res.setContentType("text/html;charset=utf-8");
		
		try {
			this.pw = res.getWriter();
			
			//데이터 삭제 결과값을 가져옴
			int cancel_result = this.resDAO.cancel_reslist(resdto);
			
			if(cancel_result > 0) {
				this.pw.print("<script>"
						+ "alert('정상적으로 방문 예약이 취소 되었습니다.');"
						+ "location.href='./reservation_list.do;'"
						+ "</script>");
			}
			else {
				this.pw.print("<script>"
						+ "alert('방문예약이 취소 되지 않았습니다. 관리자에게 문의하세요');"
						+ "history.go(-1);"
						+ "</script>");
			}
			
		}
		catch (Exception e) {
			System.out.println("방문예약 삭제시 오류 발생 " + e);
		}
		
		return null;
	}
	
	
	
	@GetMapping("/realty/reservation_list.do")
	public String reservation_list(
			Model resList_model,
	        HttpSession login_session,
	        RedirectAttributes redirectAttributes) {

	    try {
	        List<Sign_DTO> loginList = (List<Sign_DTO>) login_session.getAttribute("login");

	        if (loginList != null && !loginList.isEmpty()) {
	            Sign_DTO userInfo = loginList.get(0);
	            String wv_name = userInfo.getM_name();
	            String wv_number = userInfo.getM_number();

	            Map<String, String> login_info = new HashMap<>();
	            login_info.put("wv_name", wv_name);
	            login_info.put("wv_number", wv_number);

	            List<ReservationDTO> all_resList = this.resDAO.selet_resAll(login_info);

	            if (all_resList != null && !all_resList.isEmpty()) {
	                resList_model.addAttribute("all_resList", all_resList);
	            } else {
	                resList_model.addAttribute("resList_check", "nodata");
	            }

	            // jsp 페이지로 이동하면서 Model 값 유지됨
	            return null; 
	        } else {
	            // 로그인 안되어 있으면 flash로 알림 메시지 보내고 로그인 페이지로 리다이렉트
	            redirectAttributes.addFlashAttribute("resList_msg", "로그인 정보가 없습니다. 로그인 페이지로 이동합니다.");
	            return "redirect:/realty/login.do";
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        redirectAttributes.addFlashAttribute("msg", "예약 리스트 출력 중 오류 발생. 메인 페이지로 이동합니다.");
	        return "redirect:/realty/main.do";
	    }
	}
	
	
	@GetMapping("/realty/reservation.do")
	public String reservation(@RequestParam(value = "tidx", required = false) String tidx,
	                          @RequestParam(value = "t_name", required = false) String t_name,
	                          Model model) {
	    // 받은 tidx와 t_name을 모델에 저장하여 JSP에서 사용할 수 있도록 전달
	    model.addAttribute("tidx", tidx);
	    model.addAttribute("t_name", t_name);

	    // 해당 JSP 페이지 반환 (예: reservation.jsp)
	    return null;
	}
	
	@PostMapping("/realty/apply_reservation.do")
	public String apply_reservation(ReservationDTO resdto, Model resmodel, HttpServletResponse res) {
		res.setContentType("text/html;charset=utf-8");
	
		
		try {
			this.pw = res.getWriter();
			int result = this.resDAO.apply_reservation(resdto);
			Long tidx = resdto.getWtidx();
			String wv_name = resdto.getWv_name();
			if(result > 0) {
				this.pw.print("<script>"
						+ "alert('사전 방문예약 등록이 정상적으로 등록 되었습니다.');"
						 + "location.href='./reservation_check.do?tidx=" + tidx + "&wv_name=" + wv_name + "';"						+ "</script>"
						);
			}
			else {
				this.pw.print("<script>"
						+ "alert('사전 방문예약 등록이 정상적으로 등록 되지 못하였습니다.');"
						+ "location.history(-1);"
						+ "</script>");
			}
			
		} catch (Exception e) {
			System.out.println("사전 방문 등록에러 : " + e);
		} finally {
			this.pw.close();
		}
	
		return null;
	}
	
	@GetMapping("/realty/reservation_check.do")
	public String reservation_check
			(@RequestParam("tidx") Long tidx,
			@RequestParam("wv_name") String wv_name,
			Model cresmodel){
		
		try {
			Map<Object, Object> tidxAndwv_name = new HashMap<Object, Object>();
			tidxAndwv_name.put("tidx", tidx);					
			tidxAndwv_name.put("wv_name", wv_name);				
			
			
			List<ReservationDTO> check_reserv = this.resDAO.select_result(tidxAndwv_name) ;
			
			cresmodel.addAttribute("check_reserv",check_reserv);
			System.out.println(check_reserv);			
			
		} catch (Exception e) {
			System.out.println("reserve cont : "+e);
		}
		
		
		return null;
	}
	
}






