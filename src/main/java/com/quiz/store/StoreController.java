package com.quiz.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson02.dto.Store;
import com.quiz.lesson02.service.StoreService;

@Controller
@RequestMapping("/lesson05/quiz06")
public class StoreController {
	@Autowired
	private StoreService storeService;
	
	@GetMapping("/store-list")
	public String storeList(Model model) {
		List<Store> stores = storeService.getStoreList();
		model.addAttribute("stores", stores);
		return "store/storeList";
	}
	
	@GetMapping("/reviews")
	public String reviews(@RequestParam("storeId") int id,
			@RequestParam("storeName") String name) {
		return "store/reviewList";
	}
}
