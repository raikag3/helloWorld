package org.sysman.bean;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author ecolina
 *
 */
public class ListadoBean {
	
	
	private int pagina ;
	private int totalRegistros ; 
    private int initIndex ;
    private int endIndex ;
	private List<Object> listado =  new ArrayList<Object> ();
	private String error  = "" ;
	
	public ListadoBean() {
	
	}


	/**
	 * @return the pagina
	 */
	public int getPagina() {
		return pagina;
	}


	/**
	 * @param pagina the pagina to set
	 */
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}


	/**
	 * @return the totalRegistros
	 */
	public int getTotalRegistros() {
		return totalRegistros;
	}


	/**
	 * @param totalRegistros the totalRegistros to set
	 */
	public void setTotalRegistros(int totalRegistros) {
		this.totalRegistros = totalRegistros;
	}


	/**
	 * @return the listado
	 */
	public List<Object> getListado() {
		return listado;
	}


	/**
	 * @param listado the listado to set
	 */
	public void setListado(List<Object> listado) {
		this.listado = listado;
	}


	/**
	 * @return the initIndex
	 */
	public int getInitIndex() {
		return initIndex;
	}


	/**
	 * @param initIndex the initIndex to set
	 */
	public void setInitIndex(int initIndex) {
		this.initIndex = initIndex;
	}


	/**
	 * @return the endIndex
	 */
	public int getEndIndex() {
		return endIndex;
	}


	/**
	 * @param endIndex the endIndex to set
	 */
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public String getError() {
		return error;
	}
}