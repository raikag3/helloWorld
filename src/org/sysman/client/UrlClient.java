package org.sysman.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlClient {

	
	public  String getListValues(String urlStr) throws RuntimeException{
		  String response = "" ;
		  try {
			System.out.println("url to consume \n"+ urlStr + "\n");
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));			
			while ((response = br.readLine()) != null) {
				return response;
			}
			conn.disconnect();
		  } catch (MalformedURLException e) {			  
			 e.printStackTrace();
			 response = e.getMessage();
		  } catch (IOException e) {
			e.printStackTrace();
			response = e.getMessage();
		  }
		  return response ;
	}
	
}
