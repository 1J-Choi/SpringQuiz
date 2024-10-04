package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;

@Controller // HTML 경로 일때는 @ResponseBody가 없다
@RequestMapping("/lesson04/quiz01")
public class Lesson04quiz01Controller {
	@Autowired
	private SellerBO sellerBO;
	
	// 회원가입 화면
	// http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller"; // HTML의 경로
	}
	
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname, 
			@RequestParam("profileImageUrl") String profileImageUrl, 
			@RequestParam("temperature") double temperature) {
		// DB insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// 결과창 출력
		return "lesson04/afterAddSeller";
	}
}
