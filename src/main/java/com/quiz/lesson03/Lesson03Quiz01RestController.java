package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RestController
@RequestMapping("/lesson03/quiz01")
public class Lesson03Quiz01RestController {
	@Autowired
	private RealEstateBO realEstateBO;
	// 굳이 BO(Service)를 거치는 이유
	// 코드를 기능(Role)을 분리시켜 관리가 용이하게 하기 위함
	
	@RequestMapping("/1")
	public RealEstate quiz01_1(
			@RequestParam(value = "id", defaultValue = "1") int id) {
		return realEstateBO.getRealEstateById(id);
	}
	
	@RequestMapping("/2")
	public List<RealEstate> quiz01_2(
			@RequestParam(value = "rent_price") int rentPrice) {
		return realEstateBO.getRealEstateListByRentPrice(rentPrice);
	}
	
	@RequestMapping("/3")
	public List<RealEstate> quiz01_3(
			@RequestParam("area") int area,
			@RequestParam("price") int price) {
		return realEstateBO.getRealEstateListByAreaPrice(area, price);
	}
}
