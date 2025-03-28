package miniproject.Controller;

import java.util.List;
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

import miniproject.DAO.Md_choiceDAO;
import miniproject.DAO.Weak_infoDAO;
import miniproject.DAO.Web_infoDAO;
import miniproject.DTO.Md_choiceDTO;
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

	@GetMapping("/realty/index.do")	//금주 분양 정보, 푸터, 추천 분양정보 출력
	public String index(Model web_infoModel, Model md_choiceModel, Model weak_infoModel, HttpSession session) {		
	
	List<Weak_infoDTO> weak_infoList = this.weakdao.weakInfo_select();	//금주분양
	weak_infoModel.addAttribute("weak_infoList",weak_infoList);		//금주분양 정보 값 배열로 전달
	
	List<Web_infoDTO> web_infoList = this.webdao.webInfo_select();	//카피라이터
	web_infoModel.addAttribute("web_infoList",web_infoList);		//카피라이터 정보 배열로 전달
	session.setAttribute("web_infoList", web_infoList);	//카피라이터 session으로 데이터 유지
	
	List<Md_choiceDTO> md_choiceList = this.mddao.mdchoice_select();	//추천분양정보
	md_choiceModel.addAttribute("md_choiceList",md_choiceList);		//추천 분양 정보 배열로 전달

	return null;
	}
	
	@GetMapping("/realty/week_tails.do")
	public String week_tails(@RequestParam("t_name") String t_name, Model weak_tailsModel) {
		
		List<Weak_infoDTO> week_tailsList = this.weakdao.weekTails_select(t_name);
		weak_tailsModel.addAttribute("week_tailsList",week_tailsList);
		//System.out.println(week_tailsList.get(0).getT_adress());
		//System.out.println(week_tailsList.get(0).getT_ctrcomp());
		
		return null;
	}
	
}
