package com.java6ASM.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ParamService {
	@Autowired
	HttpServletRequest request;

	public String getString(String name, String defaultValue) {
		String value = request.getParameter(name);
		return value != null ? value : defaultValue;
	}

	public int getInt(String name, int defaultValue) {
		String value = request.getParameter(name);
		return value != null ? Integer.parseInt(value) : defaultValue;
	}

	public double getDouble(String name, double defaultValue) {
		String value = request.getParameter(name);
		return value != null ? Double.parseDouble(value) : defaultValue;
	}

	public boolean getBoolean(String name, boolean defaultValue) {
		String value = request.getParameter(name);
		return value != null ? Boolean.parseBoolean(value) : defaultValue;
	}

	public Date getDate(String name, String pattern) {
		String value = request.getParameter(name);
		if (value != null) {
			try {
				return new SimpleDateFormat(pattern).parse(value);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public String getURL() {
		String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
				.replacePath(null)
				.build()
				.toUriString();
		return baseUrl;
	}

}
