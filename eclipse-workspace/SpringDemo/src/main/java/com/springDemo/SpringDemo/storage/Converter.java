package com.springDemo.SpringDemo.storage;

import java.io.File;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter {
	private Storage storage;
	
	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public  <T> T json2Java(String fileName, Class<T> classType) {
		T t = null;
		File file = new File("src/main/resources/"+fileName);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			t=mapper.readValue(file,classType);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	

}
