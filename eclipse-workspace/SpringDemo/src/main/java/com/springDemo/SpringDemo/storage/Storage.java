package com.springDemo.SpringDemo.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springDemo.SpringDemo.models.UserImp;
@Component	
public class Storage{
	
private HashMap <String, Object> hashMap = new HashMap<>();	
Logger logger = Logger.getLogger(Storage.class);
String fileName ="user.txt";
String line =null;


public <T> T getById(String id) {
	T entity = (T)hashMap.get(id);
	return entity;
	
}

public <T> T addPair(String key, T value){
	logger.debug("Element with key:"+key + "Value:" + value + "is added to HashMap");
	hashMap.put(key, value);
	printElements();
	return value;
	
}


public boolean delete(String key) {
	return hashMap.remove(key)!=null;
			
}

//displaying hashmap contents
public void printElements() {
	 for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
	      System.out.println(entry.getKey() + ": " + entry.getValue());
	    }
}

public <T> List<T> getElementsByValue(Predicate<T> predicate, String nameSpace){
	logger.debug("Returning the values matches with condition");
	List <T> returnedList = hashMap.entrySet().stream().filter(e->e.getKey().startsWith(nameSpace)).
			map(e->(T)e.getValue()).
			filter(predicate).
			collect(Collectors.toList());
	
	System.out.println(returnedList);
	return returnedList;
}

/*
public <T> List<T> updateElement(Predicate<T> predicate, String nameSpace){
	logger.debug("Returning the values matches with condition");
	List <T> returnedList = hashMap.entrySet().stream().filter(e->e.getKey().startsWith(nameSpace)).
			map(e->(T)e.getValue()).
			filter(predicate).collect(Collectors.toList());
	 return returnedList;
	 
			

	
}*/
}
	
	
	
	
		
	

