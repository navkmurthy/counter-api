package com.navaneeth.counter.service;
import java.util.Map;
import java.util.List;

public interface WordCountService {
  	public String getTextsWithHighestCount(int topItems );									
  	public Map<String,Integer>[] getWordCounts(List<String> words);					
}