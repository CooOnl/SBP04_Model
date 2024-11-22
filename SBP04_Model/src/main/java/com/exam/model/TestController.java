package com.exam.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping("/")
	public String index() {

		return "index";
	}
	
	@RequestMapping("/test1")
	public String test1(Model model) {
		// Model는 인터페이스기에 변수로 그대로 사용 가 
		model.addAttribute("name", "딸기");
		
		return "test1";
	}
	
	@RequestMapping("/mv")
	public ModelAndView test2(ModelAndView model) {
		
		
		// ModelAndView는 클래스기에 객체를 생성해서 사용.
		ModelAndView mv = new ModelAndView();
		
		List<String> objList = new ArrayList<>();
		objList.add("apple");
		objList.add("oange");
		objList.add("melon");
		
		mv.addObject("lists", objList);
		mv.addObject("ObjectTest", "점검용 테스트");
		mv.addObject("name", "테스트2");
//				mv.setViewName("test1");
		
		 // 보여줄 페이지 .jsp 이름 세팅		
		mv.setViewName("subDir/sampleView");
		
		return mv;
		
	}
}