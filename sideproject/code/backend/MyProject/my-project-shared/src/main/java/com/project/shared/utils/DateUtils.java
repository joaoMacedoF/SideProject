package com.project.shared.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateUtils {
	
public static final String ISO_STRING_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	
	public static final String CSV_DATE_FORMAT_BIG="yyyyMMddHHmmss";
	
	public static final String SNEM_DATE_FORMAT_BIG="yyyyMMddHHmmss";
	
	public static final String FUP_DATE_FORMAT_BIG="yyyyMMddHHmmss";
	
	public static final String SNEM_DATE_FORMAT_SHORT="yyyyMMdd";

	public static final String READABLE_STRING_FORMAT = "yyyy-MM-dd";
	
	public static final String PPAP_DATE_FORMAT = "dd/MM/yyyy";

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static int daysBetween(Date date1, Date date2) {
		LocalDate now = convertToLocalDateViaInstant(date1);
		LocalDate after = convertToLocalDateViaInstant(date2);

		return (int) ChronoUnit.DAYS.between(after, now);
	}

	public static Date atStartOfDay(Date date) {
		
		if(date == null)
			return null;
		
		Calendar cal = Calendar.getInstance();

		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}

	public static Date atEndOfDay(Date date) {
		
		if(date == null)
			return null;
		
		LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
		return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
	}

	public static String getYearFromDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return String.valueOf(cal.get(Calendar.YEAR));
	}

	public static Date getNow() {
		return Date.from(Instant.now());
	}

	public static String dateToIsoString(Date date) {
		if (date == null)
			return null;

		SimpleDateFormat sdf = new SimpleDateFormat(ISO_STRING_FORMAT);
		return sdf.format(date);
	}

	public static Date isoStringToDate(String isoDateString) {
		if (StringUtils.isEmpty(isoDateString))
			return null;

		SimpleDateFormat sdf = new SimpleDateFormat(ISO_STRING_FORMAT);
		Date date = null;
		try {
			date = sdf.parse(isoDateString);
		} catch (ParseException e) {

		}
		return date;
	}

	public static String convertDateToString(Date dateToConvert) {
		LocalDate localDate = convertToLocalDateViaInstant(dateToConvert);
		return localDate.format(DateTimeFormatter.ISO_DATE);
	}

	public static Date convertLocalDateToDate(LocalDate localDate) {
		String stringIsoDate = localDate.format(DateTimeFormatter.ISO_DATE);
		return Date
				.from(parseStringToLocalDate(stringIsoDate).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	private static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	private static LocalDate parseStringToLocalDate(String dateString) {
		return LocalDate.parse(dateString);
	}

	public static String convertDateToReadableString(Date dateToConvert) {
		if (dateToConvert==null) {
			return null;			
		}
		DateFormat dateFormat = new SimpleDateFormat(READABLE_STRING_FORMAT);
		return dateFormat.format(dateToConvert);
	}
	
	public static Date convertReadableStringToDate(String dateInString) {
		if (dateInString==null) {
			return null;			
		}
		return convertStringToDate(dateInString, READABLE_STRING_FORMAT);
	}

	public static Date convertStringToDate(String dateInString, String format) {
		
		SimpleDateFormat formatter = new SimpleDateFormat(format);

		Date date = null;

		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {

		}
		return date;
	}
	
	public static Date snemStringToDate(String dateString, String formato) {
		if (StringUtils.isEmpty(dateString))
			return null;

		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			
		}
		return date;
	}
	
	public static Date fupStringToDate(String dateString, String formato) {
		if (StringUtils.isEmpty(dateString))
			return null;

		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {

		}
		return date;
	}
	
	public static boolean isValid(String dateStr, String formato) {
        DateFormat sdf = new SimpleDateFormat(formato);
        
        if(!dateStr.matches("[0-9]+")) {
        	return false;
        }
        
        sdf.setLenient(true);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
	

}
