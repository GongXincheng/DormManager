package com.gxc.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * 日期转换器
 * @author 宫新程
 */
public class DataConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		if(StringUtils.isNotBlank(source)){
			try {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(source);
				return date;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
