package com.asm.trackingpixel.util;

import java.util.UUID;

import jakarta.servlet.http.HttpServletRequest;

public class CommonUtil {
	
	/**
	 * to get host
	 * @param request
	 * @return
	 */
	public static String getHost(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
	}
	
	/**
	 * to get unique id
	 * @return
	 */
	public static String getUniquiId() {
		return UUID.randomUUID().toString();
	}

}
