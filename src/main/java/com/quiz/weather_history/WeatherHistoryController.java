package com.quiz.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/lesson05/weather-history")
@Controller
public class WeatherHistoryController {
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	@GetMapping("/weather-list-view")
	public String weatherList(Model model) {
		List<WeatherHistory> weatherHistories = weatherHistoryBO.getWeatherHistroyAll();
		model.addAttribute("weatherHistories", weatherHistories);
		
		return "weather_history/weatherList";
	}
	
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	@PostMapping("/add-weather")
	public String addWeather(@ModelAttribute WeatherHistory weatherHistory) {
		weatherHistoryBO.addWeatherHistory(weatherHistory);
		
		return "redirect:/lesson05/weather-history/weather-list-view";
	}
}
