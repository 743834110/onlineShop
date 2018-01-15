package cn.edu.lingnan.shop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	public static String format(Date date){
		return format.format(date);
	}
}
