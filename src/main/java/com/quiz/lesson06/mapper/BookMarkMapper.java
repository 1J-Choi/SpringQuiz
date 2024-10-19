package com.quiz.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson06.domain.BookMark;

@Mapper
public interface BookMarkMapper {
	public void insertBookMark(@Param("name") String name, 
			@Param("url") String url);
	public List<BookMark> selectAllBookMark();
	public boolean isDuplicateUrl(String name);
	public int deleteBookMarkById(int id);
}
