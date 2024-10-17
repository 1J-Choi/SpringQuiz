package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookMarkBO;
import com.quiz.lesson06.domain.BookMark;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {
	@Autowired
	private BookMarkBO bookMarkBO;
	
	// 등록 화면
	// http://localhost:8080/lesson06/quiz01/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookMarkView() {
		return "lesson06/addBookMark";
	}
	
	// 등록 => AJAX 호출
	// http://localhost:8080/lesson06/quiz01/add-bookmark
	@ResponseBody
	@PostMapping("/add-bookmark")
	public String AddBookMark(@RequestParam("name") String name,
			@RequestParam("url") String url) {
		bookMarkBO.addBookMark(name, url);
		return "성공";
	}
	
	// 완료 후 목록 화면
	// http://localhost:8080/lesson06/quiz01/bookmark-view
	@GetMapping("/bookmark-view")
	public String afterAddBookMarkView(Model model) {
		List<BookMark> bookMarks = bookMarkBO.getAllBookMark();
		model.addAttribute("bookMarks", bookMarks);
		return "store/bookMarkList";
	}
}
