package com.navaneeth.counter.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.navaneeth.counter.helper.CounterConstants;

@Component
public class DataFileServiceImpl implements DataFileService {
	private Stream<String> lines;
	private List<String> wordsList;

	@Autowired
	ResourceLoader resourceLoader;

	private Logger logger = Logger.getLogger(DataFileServiceImpl.class);

	@PostConstruct
	public void loadDataFile() throws IOException {
		try {
			Resource resource = resourceLoader.getResource(CounterConstants.DATA_FILE_NAME);
			File file = resource.getFile();
			Path path = file.toPath();
			
			lines = Files.lines(path); // read the lines from the file

			wordsList = lines.flatMap(line -> Arrays.stream(line.split(CounterConstants.ALPHA_NUMERIC_WORD))).collect(Collectors.toList());
		} catch (IOException ioe) {
			logger.error("Error in opening file " + CounterConstants.DATA_FILE_NAME, ioe);
		} finally {
			if (lines != null) {
				lines.close();
			}
		}
	}

	@Override
	public List<String> getWordsList() {
		return wordsList;
	}

}