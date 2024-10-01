package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RestController
public class Lesson03Quiz01RestController {
	@Autowired
	private RealEstateBO realEstateBO;
	
	@RequestMapping("/lesson03/quiz01/1")
	public RealEstate ex01_1(
			@RequestParam(value = "id", defaultValue = "1") int id) {
		return realEstateBO.getRealEstateById(id);
	}
	
	@RequestMapping("/lesson03/quiz01/2")
	public List<RealEstate> ex01_2(
			@RequestParam(value = "rent_price") int rentPrice) {
		return realEstateBO.getRealEstateByRentPrice(rentPrice);
	}
	
	@RequestMapping("/lesson03/quiz01/3")
	public List<RealEstate> ex01_3(
			@RequestParam(value = "area") int area,
			@RequestParam(value = "price") int price) {
		return realEstateBO.getRealEstateByAreaAndPrice(area, price);
	}
}
