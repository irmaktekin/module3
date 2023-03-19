/*package com.springDemo.SpringDemo.processor;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.springDemo.SpringDemo.storage.ProcessedBean;
import com.springDemo.SpringDemo.storage.Storage;
import com.springDemo.SpringDemo.storage.jsonToUser;



public class ProcessorData  implements BeanPostProcessor {
	
	
	public ProcessorData() {
		super();
	}


	Logger logger = Logger.getLogger(ProcessorData.class);
	private Storage storage;
	private jsonToUser userSave;
	
	public ProcessorData(jsonToUser userSave) {
		super();
		this.userSave = userSave;
	}

	
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	@Override
	public Object postProcessAfterInitialization(
	        Object bean, String beanName) throws BeansException
	
	    {

        System.out.println("PostProcessor Before Initialization called '" + beanName + bean.toString());
			if(bean instanceof Storage) {
		        logger.debug("postProcessAfterInitialization() is called for Storage");

				userSave.json2Java("user.json",jsonToUser.class );
			}
		
return bean.toString();

	    }
	
	
	
	@Override
	  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
	    return bean;
	  }
		}*/
