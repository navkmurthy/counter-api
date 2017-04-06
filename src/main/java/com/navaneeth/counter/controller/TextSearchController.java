 package com.navaneeth.counter.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.navaneeth.counter.model.SearchParams;
import com.navaneeth.counter.model.SearchResult;
import com.navaneeth.counter.service.WordCountService;

@RestController
@RequestMapping("/search")

public class TextSearchController{
	@Autowired  
	WordCountService wordCountService;  
	@RequestMapping(  method = RequestMethod.POST, produces = "application/json", consumes = "application/json" )
	public @ResponseBody SearchResult getWordSearch(@Valid @RequestBody SearchParams searchParams) {

		List<String> wordsList = searchParams.getSearchText();   	
		
		SearchResult searchResults = new SearchResult();
		Map<String,Integer>[] wordCounts = wordCountService.getWordCounts(wordsList);
		searchResults.setWordCountMap(wordCounts);													
		return searchResults;                                                               
	}
}