package com.navaneeth.counter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.navaneeth.counter.helper.CounterConstants;
import com.navaneeth.counter.model.WordCount;

@Service
public class WordCountServiceImpl implements WordCountService {
	@Autowired
	DataFileService dataFileService;

	private Map<String, WordCount> wordCountMap = new HashMap<>();
	private List<WordCount> wordCountList;

	public WordCountServiceImpl() {
	}

	@PostConstruct
	public void init() {
		populateWordCountMap();
		populateSortedListOfWordsByCount();
	}

	public String getTextsWithHighestCount(int topItems) {

		if (topItems < 1)
			return "";

		List<WordCount> topmostTokenCount = wordCountList.stream().limit(topItems).collect(Collectors.toList());

		String result = topmostTokenCount.stream().map(x -> x.getFormatedValue())
				.collect(Collectors.joining(CounterConstants.NEW_LINE));
		return result;
	}

	public Map<String, Integer>[] getWordCounts(List<String> words) {

		Map<String, Integer>[] countMap = new HashMap[words.size()];
		int count = 0;
		for (String word : words) {
			countMap[count] = new HashMap<String, Integer>();
			countMap[count].put(word, getCountOfWordFromWordMap(word));
			count++;
		}

		return countMap;
	}

	private void populateWordCountMap() {

		List<String> wordList = dataFileService.getWordsList();

		wordList.forEach(item -> {
			item = item.toLowerCase();
			if (wordCountMap.containsKey(item)) {
				wordCountMap.get(item).incrementCount();
			} else {
				wordCountMap.put(item, new WordCount(item));
			}
		});
	}

	private void populateSortedListOfWordsByCount() {

		wordCountList = wordCountMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
		sortByWordCount(); // sort list based on Count

	}

	private void sortByWordCount() {
		if (!CollectionUtils.isEmpty(wordCountList)) {
			wordCountList.sort((WordCount o1, WordCount o2) -> o2.getCount() - o1.getCount());
		}
	}

	private int getCountOfWordFromWordMap(String word) {
		word = word.toLowerCase();
		return (wordCountMap.containsKey(word) ? wordCountMap.get(word).getCount() : 0);
	}

}
