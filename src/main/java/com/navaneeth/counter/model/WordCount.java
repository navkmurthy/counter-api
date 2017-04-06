package com.navaneeth.counter.model;

import com.navaneeth.counter.helper.CounterConstants;

public class WordCount {
	
	private String word;
	private int count=1;
	

	public WordCount(String word) {
		this.word = word;		
	}
	
	public WordCount(String word, int count) {
		this.word = word;
		this.count = count;
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public int incrementCount() {
		count += 1;
		return count;
	}
	
	public String getFormatedValue() {
		return count + CounterConstants.SEPERATOR + word + " " ;
	}

}
