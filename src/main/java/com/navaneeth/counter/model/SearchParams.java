package com.navaneeth.counter.model;

import java.util.List;

public class SearchParams   {
 
  	private List<String> searchText;	 
  	
	public SearchParams() {
		
	}
	
	public SearchParams(List<String> searchText) {
		super();
		this.searchText = searchText;
	}	
 
	public List<String> getSearchText() {
		return searchText;
	}

	public void setSearchText(List<String> searchText) {
		this.searchText = searchText;
	}
}

 