package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RestController
@RequestMapping("/lesson07/quiz02")
public class Lesson07Quiz02RestController {
	@Autowired
	private RecruitRepository recruitRepository;
	
	// 문제1) JPQL
	
	// 1. id로 조회
	@GetMapping("/1")
	public RecruitEntity select1() {
		return recruitRepository.findById(8).orElse(null);
	}
	
	// 2. companyId가 1인 회사들 조회
	@GetMapping("/2")
	public List<RecruitEntity> select2(
			@RequestParam("companyId") int companyId) {
		return recruitRepository.findByCompanyId(companyId);
	}
	
	// 3. 복합조건 웹 back-end 개발자 이고 정규직
	@GetMapping("/3")
	public List<RecruitEntity> select3() {
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	// 4. 정규직이거나 연봉이 9000 이상
	@GetMapping("/4")
	public List<RecruitEntity> select4() {
		return recruitRepository.findByTypeOrSalaryGreaterThan("정규직", 9000);
	}
	
	// 5. 계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회
	@GetMapping("/5")
	public List<RecruitEntity> select5() {
		return recruitRepository.findTop3ByOrderBySalaryDesc();
	}
	
	// 6. 성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고
	@GetMapping("/6")
	public List<RecruitEntity> select6() {
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
}
