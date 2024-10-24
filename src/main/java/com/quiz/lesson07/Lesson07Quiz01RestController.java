package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RestController
@RequestMapping("/lesson07/quiz01")
public class Lesson07Quiz01RestController {
	@Autowired
	private CompanyBO companyBO;
	
	// 1. Create
	// 넥손 insert
	@GetMapping("/save1")
	public CompanyEntity create1() {
		return companyBO
				.addCompany("넥손", "컨텐츠 게임", "대기업", 3585);
	}
	
	// 버블팡 insert
	@GetMapping("/save2")
	public CompanyEntity create2() {
		return companyBO
				.addCompany("버블팡", "여신 금융업", "대기업", 6834);
	}
	
	// 2.Update
	// 버블팡의 규모 중소기업, 사원수 35
	@GetMapping("/update")
	public CompanyEntity update() {
		return companyBO.updateCompanyScaleHeadcountById(10, "중소기업", 35);
	}
	
	// 3.Delete
	// 버블팡(id 10) 삭제
	@GetMapping("/delete")
	public String delete() {
		companyBO.deleteCompanyById(10);
		return "수행 완료";
	}
}
