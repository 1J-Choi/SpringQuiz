package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {
	public RealEstate selectRealEstateById(int id);
	public List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);
	public List<RealEstate> selectRealEstateListByAreaPrice(
			// 파라미터를 2개 이상 xml에 보낼 수 없다.
			// 따라서 하나의 Map으로 구성해야하는데 이를 @Param이 해준다
			@Param("area") int area, 
			@Param("price") int price);
	// input: RealEstate
	// output: int(성공한 행의 개수)
	public int insertRealEstate(RealEstate realEstate);
	// input: 파라미터들
	// output: int(성공한 행의 개수)
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") Integer rentPrice
			);
}
