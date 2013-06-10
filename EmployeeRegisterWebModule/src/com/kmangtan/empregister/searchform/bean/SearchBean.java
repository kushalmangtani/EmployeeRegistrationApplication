package com.kmangtan.empregister.searchform.bean;

import java.io.Serializable;

public class SearchBean implements Serializable {
	
	/**
	 * Bean used for Search Page
	 * 
	 */
	private static final long serialVersionUID = 4720126892773520416L;

	public SearchBean()
	{
		
	}
	
	 String search_text;
	 String search_using;
	
	public String getSearch_text() {
		return search_text;
	}

	public void setSearch_text(String search_text) {
		this.search_text = search_text;
	}

	public String getSearch_using() {
		return search_using;
	}

	public void setSearch_using(String search_using) {
		this.search_using = search_using;
	}

  
	
}
