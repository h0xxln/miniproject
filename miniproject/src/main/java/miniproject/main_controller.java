package miniproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class main_controller {
	@GetMapping("/test.do")
	public void test(Model m) {
		System.out.println("test");
		m.addAttribute("test","연습!!");
	}
		
}
