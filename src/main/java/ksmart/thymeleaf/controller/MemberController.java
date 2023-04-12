package ksmart.thymeleaf.controller;


import ksmart.thymeleaf.dto.Member;
import ksmart.thymeleaf.service.ExamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @RestController => @ResponseBody+ @Controller
// 깃연습
@RestController
@RequestMapping("/memberInfo")
public class MemberController {
	//DI 주입
	private final ExamService examService;
	
	public MemberController(ExamService examService) {
		this.examService = examService;
	}
	
	@GetMapping("/list")
	public List<Member> getMemberList(){
		List<Member> memberList = examService.getMemberList();
		return memberList;
	}
	
	
	
	
	@GetMapping("/{memberId}")
	public Member getMemberInfoById(@PathVariable(value="memberId")String memberId) {
		Member memberInfo = examService.getMemberInfoById(memberId);
		
		return memberInfo;
		
	}

	
	
	
	
	
	
	
	
}
