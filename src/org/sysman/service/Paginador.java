package org.sysman.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.sysman.bean.ListadoBean;
import org.sysman.client.UrlClient;
import org.sysman.util.CommonsUtil;
import org.sysman.util.JsonEnum;
import org.sysman.util.JsonUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

@Path("/paginador")
public class Paginador {

	
	@GET
	public  String paginar (@QueryParam("baseUrl") String uBase,
							@QueryParam("method1") String method_count,
							@QueryParam("method2") String method_selectAll,
							@QueryParam("pagina") String actualPage,
							@QueryParam("regXpagina") String regPage) {
		
				String url ;
				
				String response = "" ; 
					response = getTotalRegistros (uBase+method_count) ;
						
				JsonUtil jsonUtil = new JsonUtil() ; 
				ListadoBean list = jsonUtil.getListBeanFromJson(response);
				
				/* seteando variables desde webservice */
				Double page = Double.parseDouble(actualPage);
				Double limit = Double.parseDouble(regPage);		
				Double regLista = Double.parseDouble(""+list.getTotalRegistros());
				
				/* variables para paginacion */
				Double pages = 0.0;
				Double init = 0.0 ;
				Double end = 0.0 ;
				
				/* validar pagina  & registros por pagina mayores que cero */
				if (page>0 && limit>=1.0) {
					/* calcular rangos paginacion */ 
					pages = regLista / limit ; 
					 
						if (page<= 1.0 ) {
							init = 1.0 ;
							end = limit ; 
						}else if (page>=pages) {
							init = Math.min(calcularEnd(page-1.0 ,limit,regLista), ((page*limit)-limit) );
							end = calcularEnd (page , limit , regLista); 
						}else {
							init = Math.min(calcularEnd(page-1.0 ,limit,regLista), ((page*limit)-limit) );
							end = calcularEnd (page , limit , regLista); 				
						} 			
					
				/* gatillar error cuando se reciben valores fuera de rango*/	
				}else {
					list.setError("Pagina fuera de rando ");
				}
				
				/* Creando mapa para parametros llamado a paginador*/
				Map params = new HashMap<String ,String > () ;
					params.put("init", init) ;		
					params.put("end", end);
				
				/* Seteando valores lista en el ValueObject */	
					list.setInitIndex(init.intValue());
					list.setPagina(page.intValue());
					list.setEndIndex(end.intValue());	
					
				CommonsUtil util = new CommonsUtil() ; 
					url = util.buildUrl(uBase+method_selectAll, params) ;
				response = jsonUtil.getJsonFromListadoBean(list);	
				if (list.getError().equals("")) {
					/*Llamando al metodo para obtener el listado en forma paginada */	
					response = getAllReg (url, response) ;
				}
		
		return response;	
	
	
	}
	
	private static Double calcularEnd (Double page, Double regP ,Double totalReg) {
		if (page <= 1) {
			return regP ;
		}else {
			if ( page >= (totalReg/regP)) {
				return totalReg ;
			}else {
				return (page * regP)  ;
			}
		}
		
	}	

	private String getTotalRegistros (String url) {
		
		ListadoBean list = new ListadoBean () ;
		
			String response = ""  ;
			UrlClient client = new UrlClient();
			response = client.getListValues(url);
			JsonUtil jutil = new JsonUtil();
			JsonArray jarray = jutil.getJsonArray(response, JsonEnum.DEFAULT ) ;
			String totReg = jarray.get(0).getAsJsonObject().get("TOTAL").getAsString() ;
			
			int totalReg = Integer.valueOf(totReg) ;			
			list.setTotalRegistros(totalReg);
		
		 
		return jutil.getJsonFromListadoBean(list) ;
		
	}

	private String getAllReg (String url , String response1 ) {
			
		    String response = ""  ;
			UrlClient client = new UrlClient();
			
			response = client.getListValues(url);
			JsonUtil jutil = new JsonUtil();
			JsonArray jarray = jutil.getJsonArray(response, JsonEnum.DEFAULT ) ;
			ListadoBean listado =  jutil.getListBeanFromJson(response1);
			
			List<Object> list = new java.util.ArrayList<Object>();     						
				if (jarray != null) { 
				
				   int len = listado.getEndIndex() ;
				  
				for (Iterator<JsonElement> it = jarray.iterator() ; it.hasNext();){
					 list.add(it.next().toString().replaceAll("\"", ""));
				}
				
				
				}
			listado.setListado(list);
			
			return  jutil.getJsonFromListadoBean(listado) ;
	}
	
	
}
