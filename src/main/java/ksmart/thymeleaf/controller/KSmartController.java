package ksmart.thymeleaf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//서블릿 파일 (KsmartView)
// Controller 의 역할 
/* @Component > 1. @Controller : HTTP 통신에 요청과 응답
 * @author OJW 
 */
@Controller
public class KSmartController {
	/*
	 * @RequestMapping => 클라이언트 주소요청 시 주소 라우팅
	 * @param model => 화면에 전달될 DATA 객체
	 * @return String => 동적 view 논리주소 경로 저장
	 * "classpath:/templates/" +"ksmart/ksmartView" + ".html"; 
	 * 경로의 앞에 /는 무조건 뺀다. 이게 폴더 경로 말하는거임.
	 * 컨트롤러 안의 String 안에 있는 경로 -> 논리적 주소
	 */
	@RequestMapping(value="/KSmartView" , method =RequestMethod.GET)
	public String kSmartView(Model model) {
		
		model.addAttribute("title", "ksmartView");
		model.addAttribute("content","한국스마트정보교육원 46기");
		
		return "ksmart/KSmartView";
	}
	
}
