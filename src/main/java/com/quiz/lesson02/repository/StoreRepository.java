package com.quiz.lesson02.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson02.dto.Store;

@Mapper
public interface StoreRepository {
	public List<Store> selectStoreList();
}
