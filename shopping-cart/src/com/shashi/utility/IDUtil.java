package com.shashi.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IDUtil {

	public static String generateId() {
		String pId = null;
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		pId=sdf.format(new Date());
		pId = "P"+pId;
		
		return pId;
	}
}
