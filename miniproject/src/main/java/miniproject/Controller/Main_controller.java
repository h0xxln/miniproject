package miniproject.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import miniproject.DAO.Md_choiceDAO;
import miniproject.DAO.Reservation_DAO;
import miniproject.DAO.Weak_infoDAO;
import miniproject.DAO.Web_infoDAO;
import miniproject.DTO.Md_choiceDTO;
import miniproject.DTO.ReservationDTO;
import miniproject.DTO.Sign_DTO;
import miniproject.DTO.Weak_infoDTO;
import miniproject.DTO.Web_infoDTO;



//index 컨트롤러
@Controller
public class Main_controller {
	
	@Resource(name="Web_infoDAO")
	private Web_infoDAO webdao;
	
	@Resource(name="Weak_infoDAO")
	private Weak_infoDAO weakdao;
	
	@Resource(name="Md_choiceDAO")
	private Md_choiceDAO mddao;
	
	@Resource(name="Reservation_DAO")
	private Reservation_DAO resDAO;

	@GetMapping("/realty/index.do")	//금주 분양 정보, 푸터, 추천 분양정보 출력
	public String index(Model web_infoModel, Model md_choiceModel, Model weak_infoModel, HttpSession session) {		
	
	List<Weak_infoDTO> weak_infoList = this.weakdao.weakInfo_select();	//금주분양
	weak_infoModel.addAttribute("weak_infoList",weak_infoList);		//금주분양 정보 값 배열로 전달
	session.setAttribute("weekList", weak_infoList);
	
	List<Web_infoDTO> web_infoList = this.webdao.webInfo_select();	//카피라이터
	web_infoModel.addAttribute("web_infoList",web_infoList);		//카피라이터 정보 배열로 전달
	session.setAttribute("web_infoList", web_infoList);	//카피라이터 session으로 데이터 유지
	
	List<Md_choiceDTO> md_choiceList = this.mddao.mdchoice_select();	//추천분양정보
	md_choiceModel.addAttribute("md_choiceList",md_choiceList);		//추천 분양 정보 배열로 전달

	return null;
	}
	
	@GetMapping("/realty/week_tails.do")
	public String week_tails(@RequestParam("tidx") String tidx,
			@SessionAttribute(name="login" , required = false)  List<Sign_DTO> login,
			Model weak_tailsModel, 
			Model check_visitModel, 
			HttpSession session) {
		
		//페이지 출력
		List<Weak_infoDTO> week_tailsList = this.weakdao.weekTails_select(tidx);
		weak_tailsModel.addAttribute("week_tailsList",week_tailsList);
		session.setAttribute("week_session", week_tailsList);
		
		String n = "nologin"; // 로그인 정보 없음 
		
		if (login == null || login.isEmpty()) {
			return null;	//로그인 안되면 바로 리턴함
	    }
		else {
		//해당 뷰의 방문예약 신청 여부 확인
		String wv_number = login.get(0).getM_number(); 
		System.out.println("main*******"+tidx+"***********" + wv_number);
		Map<Object, Object> check_vlist = new HashMap<Object, Object>();
		check_vlist.put("tidx", tidx);
		check_vlist.put("wv_number", wv_number);
		
		String msg = ""; // 최종 결과값 프론트에 전송
		List<ReservationDTO> check_result = this.resDAO.check_visit(check_vlist);
		
		if (check_result.isEmpty()) {
		    msg ="yes"; //결과 값 없을 경우 방문예약 가능
		} else if(check_result.get(0).getWv_number() != null) {
		    msg = "no";	//결과 값이 있을 경우엔 방문예약 불가능
		}
		
		check_visitModel.addAttribute("cvisit_msg",msg);
		
		
		
		return null;
		}
	}
	
}
