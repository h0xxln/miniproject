package miniproject.Controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import miniproject.DAO.Reservation_DAO;
import miniproject.DTO.ReservationDTO;
import miniproject.DTO.Weak_infoDTO;

@Controller
public class Reservation_Controller {
	
	@Resource(name="Reservation_DAO")
	private Reservation_DAO resDAO;
	
	PrintWriter pw = null;
	
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






