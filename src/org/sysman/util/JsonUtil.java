package org.sysman.util;

import java.io.IOException;

import org.sysman.bean.ListadoBean;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;



public class JsonUtil {
	
	public JsonUtil() {
		
	}
	
	/**
	 * Permite cargar y obtener un objeto JsonArray a partir de un contenido json.
	 */
	public  JsonArray getJsonArray(String jsonContent, JsonEnum jsonEnum) {
		com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
		com.google.gson.JsonElement jsonElement = parser.parse(jsonContent);

		com.google.gson.JsonObject  jsonObject  = jsonElement.getAsJsonObject();
		com.google.gson.JsonElement jsonBase    = jsonObject.get(jsonEnum.getBase());
		
		com.google.gson.JsonObject  jsonObjectContainer = jsonBase.getAsJsonObject();
		com.google.gson.JsonElement jsonContainer       = jsonObjectContainer.get(jsonEnum.getContainer());
		com.google.gson.JsonArray 	gsonArray 			= jsonContainer.getAsJsonArray();
		return gsonArray;
	}
	
	
	public String getJsonFromListadoBean (ListadoBean list )  {
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "" ;
		try {
			 jsonInString = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		return jsonInString ; 
	}
	
	
	public ListadoBean getListBeanFromJson (String jsonInString) {
		ObjectMapper mapper = new ObjectMapper();
		ListadoBean list = new  ListadoBean() ; 
		
		 try {
			list = mapper.readValue(jsonInString, ListadoBean.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return list;
	}
}