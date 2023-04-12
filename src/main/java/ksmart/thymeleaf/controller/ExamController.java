package ksmart.thymeleaf.controller;

import jakarta.annotation.PostConstruct;
import ksmart.thymeleaf.dto.Member;
import ksmart.thymeleaf.service.ExamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;


@Controller
@Slf4j
public class ExamController {
    /*
     * @PostConstruct : 객체가 생성 뒤에 이벤트 처리
     *
     */

    @PostConstruct
    public void ExamControllerInit() {
        System.out.println("ExamController 객체(Bean) 생성");

    }

	/*
	 *  DI (Dependency InJection :의존성 주입) 3가지 방법.
	 *  @Autowired 의존성을 주입시키는 어노테이션
	 *  1. 필드 주입방식
	 *  @Autowired
	 *  private Examservice examService;
	 *
	 *
	 *  2. 수정자 메소드 주입방식
	 *  private ExamService examService;
	 *  	@Autowired
			// 이 시점에서 세팅을 하고 위쪽 examService 에 놓는다.
			public void setExamService(ExamService examService) {
			this.examService = examService;
			}

	 *
	 *  3. 생성자 메소드 주입방식
	 *    private final ExamService examService;
	 *      @Autowired 생략 가능
            public ExamController(ExamService examService) {
            this.examService = examService;
             }
	 */



    private final ExamService examService;
    public ExamController(ExamService examService) {
        this.examService = examService;

    }



    /*
     * rest api 주소의 값을 바인딩하는 방법
     * 응답시 응답의 바디영역에 객체의 정보를 주겠다.
     * 객체의 정보는 전달해주겠다.
     * @responseBody < 응답할 바디에 json형식으로 던져주겠다.
     * 주소는 필요없다 정보만 던져준다
     */

    @GetMapping("/member/{memberId}")
    @ResponseBody
    public Member getMemberInfoById(@PathVariable(value="memberId") String memberId) {
        System.out.println("memberId:" + memberId);
        Member memberInfo = examService.getMemberInfoById(memberId);
        return memberInfo;
    }



    /*
     * 쿼리스트링 받는 방법
     * 1. @requestParam (value="키", defaultValue="널일경우 초기값 설정", name="키"
     * 					,required="ture | false" -> 키값은 무조건 존재여부) 데이터타입 매개변수명
     * 2. 커맨드 객체 (잘 만들어 놓은 dto) set get 메서드가 미리 존재해야하고 카멜표기법준수가 필수임. 그래야 쓸수있음
     * 	@return
     * 3. 생성자 메소드 주입방식
     */


    @GetMapping("/exam8")
    public String exam8(Model model) {
        model.addAttribute("title", "exam8 ajax");
        return "exam/exam8";
    }


    @GetMapping("/exam7")
    public String exam7(@RequestParam(value="memberId", defaultValue="id001", required = false) String memberId
            ,Member member
            ,Model model){
        System.out.println("애노테이션 memberId:" +memberId);
        System.out.println("커맨드객체 memberId:" +member.getMemberId());
        Member memberInfo = examService.getMemberInfoById(memberId);
        model.addAttribute("title", "exam7");
        model.addAttribute("memberInfo", memberInfo);

        return "exam/exam7";
    }



    @GetMapping("/exam6")
    public String exam6(Model model) {
        Member memberInfo = examService.getMemberInfoById("id002");
        model.addAttribute("title", "exam6");
        model.addAttribute("memberInfo", memberInfo);

        return "exam/exam6";
    }



    @GetMapping("/exam5")
    public String exam5(Model model) {
        List<Member> memberList = examService.getMemberList();
        model.addAttribute("title","exam5");
        model.addAttribute("memberList", memberList);
        model.addAttribute("now" , new Date());
        model.addAttribute("price", 5000000);

        return "exam/exam5";
    }



    @GetMapping("/exam4")
    public String exam4(Model model) {
        List<Member> memberList = examService.getMemberList();
        //특정회원 조회 id003 Pw003 (1. 관리자 2.판매자, 3. 구매자), 홍03, 연락처(010-0003-0003
        Member memberInfo = examService.getMemberInfoById("id003");
        model.addAttribute("title", "exam4");
        model.addAttribute("memberInfo", memberInfo);
        model.addAttribute("memberList", memberList);

        return "exam/exam4";
    }

    @GetMapping("/exam3")
    public String exam3(Model model) {
        List<Member> memberList = examService.getMemberList();
        Member memberInfo = examService.getMemberInfo();
        model.addAttribute("title", "exam3");
        model.addAttribute("memberInfo", memberInfo);
        model.addAttribute("memberList", memberList);

        return "exam/exam3";
    }



    @GetMapping("/exam2")
    public String exam2(Model model) {
        List<Member> memberList =  examService.getMemberList();
        model.addAttribute("title","exam2");
        model.addAttribute("memberList",memberList);

        return "exam/exam2";
    }





	/*

	public ModelAndView exam1() {



		ModelAndView mav = new ModelAndView();

		mav.addObject("title","exam1");

		mav.setViewName("exam/exam1");

		return mav;

	 */

    /* @GetMapping("/exam1") -> 클라이언트가 서버 get 방식 요청시 주소 매핑해주는 어노테이션

     * @param model -> 화면에 전달되는 data 객체

     * @return	type : String -> 논리적인 경로 (동적 view html)

     */

    @GetMapping("/exam1")
    public String exam1(Model model) {
        Member memberInfo = examService.getMemberInfo();
        model.addAttribute("title", "exam1");
        model.addAttribute("memberInfo", memberInfo);

        return "exam/exam1";
    }
}