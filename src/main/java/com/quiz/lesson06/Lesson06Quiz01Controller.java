package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	// url 중복 확인 => AJAX 호출
	// http://localhost:8080/lesson06/quiz01/is-duplicated-url
	@ResponseBody
	@RequestMapping("/is-duplicated-url")
	public Map<String, Object> isDuplicateUrl(
			@RequestParam("url") String url) {
		// DB select
		boolean isDuplicatedUrl = bookMarkBO.isDuplicateUrl(url);
		
		// return Map => JSON parsing
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplicated_url", isDuplicatedUrl);
		
		return result;
	}
	
	// 등록 => AJAX 호출
	// http://localhost:8080/lesson06/quiz01/add-bookmark
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> AddBookMark(@RequestParam("name") String name,
			@RequestParam("url") String url) {
		bookMarkBO.addBookMark(name, url);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
	
	// 완료 후 목록 화면
	// http://localhost:8080/lesson06/quiz01/bookmark-view
	@GetMapping("/bookmark-view")
	public String afterAddBookMarkView(Model model) {
		List<BookMark> bookMarks = bookMarkBO.getAllBookMark();
		model.addAttribute("bookMarks", bookMarks);
		return "lesson06/bookMarkList";
	}
	
	// 북마크 제거 => AJAX 호출
	// http://localhost:8080/lesson06/quiz01/delete-bookMark
	@ResponseBody
	@RequestMapping("/delete-bookMark")
	public Map<String, Object> deleteBookMark(
			@RequestParam("id") int id) {
		// DB delete
		int isDeleted = bookMarkBO.deleteBookMarkById(id);
		
		// return Map => JSON parsing
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_deleted", isDeleted);
		
		return result;
	}
}
