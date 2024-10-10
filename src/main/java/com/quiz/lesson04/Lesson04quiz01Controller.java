package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

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
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl, 
			@RequestParam(value = "temperature", defaultValue = "36.5") double temperature) {
		// temperature의 경우 nullable 일 경우 Double을 써야한다!
		// DB insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// 결과창 출력
		return "lesson04/afterAddSeller";
	}
	
	@GetMapping("/seller-info-view")
	public String sellerInfoView(Model model,
			@RequestParam(value = "id", required = false) Integer id) {
		// DB select
		Seller seller;
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		
		// Model
		model.addAttribute("seller", seller);
		if(seller == null) {
			model.addAttribute("title", "존재하지 않는 id 입니다.");
		} else {
			model.addAttribute("title", "판매자 정보");
		}
		
		// view 경로
		return "lesson04/sellerInfo";
	}
}
