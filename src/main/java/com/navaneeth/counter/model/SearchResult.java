 package com.navaneeth.counter.model;
 import java.util.Map;

public class SearchResult {

	private Map<String,Integer>[] wordCountMap;
	
	public SearchResult() {
	}
 
	public Map<String,Integer>[] getWordCountMap() {
		return wordCountMap;
	}
	public void setWordCountMap(Map<String,Integer>[] wordCountMap) {
		this.wordCountMap = wordCountMap;
	}
}