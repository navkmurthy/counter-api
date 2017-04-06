package com.navaneeth.counter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.navaneeth.counter.service.WordCountService;

@RestController

@RequestMapping( "/top")

public class TopWordCountController{
	@Autowired  
	WordCountService wordCountService;  
	@RequestMapping(value = "{topValue}", method = RequestMethod.GET, produces = "text/csv"  )
	public @ResponseBody String getTopWords(@PathVariable String topValue) {

		int count = 0;
		try {
			count = Integer.parseInt(topValue);
		}
		catch(NumberFormatException e) {
			return String.format("Invalid numeric value : {} ", topValue);
			
 		}
 
		return wordCountService.getTextsWithHighestCount(count) ;
 	}
}

