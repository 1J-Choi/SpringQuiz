package com.quiz.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@Controller
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	private BookingBO bookingBO;
	
	// 1. 예약 리스트 화면 (삭제)
	// http://localhost:8080/booking/booking-list-view
	@GetMapping("/booking-list-view")
	public String bookingList(Model model) {
		List<Booking> bookings = bookingBO.getBookingAll();
		model.addAttribute("bookings", bookings);
		return "booking/bookingList";
	}
	
	// 삭제 요청 => AJAX
	// http://localhost:8080/booking/delete-booking
	@ResponseBody
	@PostMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		int isDeleted = bookingBO.removeBookingById(id);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_deleted", isDeleted);
		
		return result;
	}
	
	// 2. 예약 등록 화면
	// http://localhost:8080/booking/make-booking-view
	@GetMapping("/make-booking-view")
	public String makeBooking() {
		return "booking/makeBooking";
	}
	
	// 예약 등록 => JSON
	// http://localhost:8080/booking/make-booking
	@ResponseBody
	@PostMapping("/make-booking")
	public Map<String, Object> makeBooking(
			@RequestParam("name") String name,
			@RequestParam("date") LocalDate date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber
			) {
		int isInserted = bookingBO.insertBooking(name, headcount, day, date, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_inserted", isInserted);
		
		return result;
	}
	
	// 3. 메인 화면 (조회)
	// http://localhost:8080/booking/check-booking-view
	@GetMapping("/check-booking-view")
	public String checkBooking() {
		return "booking/checkBooking";
	}
}
