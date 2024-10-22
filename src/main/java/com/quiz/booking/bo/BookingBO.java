package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {
	@Autowired
	private BookingMapper bookingMapper;
	
	public List<Booking> getBookingAll() {
		return bookingMapper.selectBookingAll();
	}
	
	public int removeBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	public int insertBooking(String name, int headcount, int day, LocalDate date, String phoneNumber) {
		return bookingMapper.insertBooking(name, headcount, day, date, phoneNumber);
	}
}
