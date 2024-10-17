package com.quiz.lesson06.bo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.BookMark;
import com.quiz.lesson06.mapper.BookMarkMapper;

@Service
public class BookMarkBO {
	@Autowired
	private BookMarkMapper bookMarkMapper;
	
	public void addBookMark(String name, String url) {
		bookMarkMapper.insertBookMark(name, url);
	}
	public List<BookMark> getAllBookMark() {
		return bookMarkMapper.selectAllBookMark();
	}
}
