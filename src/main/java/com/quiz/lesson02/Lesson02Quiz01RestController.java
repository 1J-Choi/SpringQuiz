package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.dto.Store;
import com.quiz.lesson02.service.StoreService;

@RestController
public class Lesson02Quiz01RestController {
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/lesson02/quiz01")
	public List<Store> ex01() {
		List<Store> storeList = storeService.getStoreList();
		return storeList;
	}
}
