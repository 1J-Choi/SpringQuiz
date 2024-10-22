package com.quiz.booking.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.booking.domain.Booking;

@Mapper
public interface BookingMapper {
	public List<Booking> selectBookingAll();
	public int deleteBookingById(int id);
	public int insertBooking(
			@Param("name") String name
			, @Param("headcount") int headcount
			, @Param("day") int day
			, @Param("date") LocalDate date
			, @Param("phoneNumber") String phoneNumber
			);
}
