package org.sysman.util;

import java.util.Map;
import java.util.Set;

import org.sysman.util.commons.enums.SignEnum;



public class CommonsUtil {

	
	public  String buildUrl(String url, Map<String, String> params) {
		String parameters = "";
		if (ObjectUtility.isObjecNotNullOrEmpty(params, true)) {
			Set<String> keys = params.keySet();
			StringBuilder sb = new StringBuilder(SignEnum.QUESTION.getValue());
			for (String key : keys) {
				sb.append(key).append(SignEnum.EQUAL.getValue()).append(String.valueOf(params.get(key))).append(SignEnum.AMPERSAND.getValue());
			}
			parameters = sb.substring(0, sb.length() - 1);
			url += parameters;
		}
		return url;
	}
	
}
