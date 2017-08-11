package com.funcional.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;

public class ManipulateDate {

	private static String[] monthsStrings = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
			"Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };
	
	private static Map<String, Object> days;
	static {
		days = new LinkedHashMap<String, Object>();
		for (int i = 1; i <= 31; i++) {
			days.put(String.valueOf(i), String.valueOf(i));
		}
	}
	
	
	private static Map<String, Object> months;
	static {
		months = new LinkedHashMap<String, Object>();
		for (int i = 1; i <= 12; i++) {
			months.put(String.valueOf(i), String.valueOf(i));
		}
	}
	
	private static Map<String, Object> years;
	public static Calendar calendar = GregorianCalendar.getInstance();
	static {
		years = new LinkedHashMap<String, Object>();
		int year = calendar.get(Calendar.YEAR);
		for (int i = year - 18; i >= year -100; i--) {
			years.put(String.valueOf(i), String.valueOf(i));
			
		}
	}
	
	public static Map<String, Object> getDays(){
		return days;
	}
	
	public static Map<String, Object> getMonths(){
		return months;
	}
	
	public static Map<String, Object> getYears(){
		return years;
	}

	
	public static Date getDate (int year, int month, int day) {
		return (new GregorianCalendar(year,month -1, day)).getTime();
	}

	public static String[] getMonthsStrings() {
		return monthsStrings;
	}

	public static void setMonthsStrings(String[] monthsStrings) {
		ManipulateDate.monthsStrings = monthsStrings;
	}
}


