package com.springbook.ioc.injection;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		// List<String> addressList = bean.getAddressList();
		// Set<String> addressList = bean.getAddressList(); //set은 같은 값을 넣으면 한 번만 저장된다.
		// Map<String, String> addressList = bean.getAddressList();
		 Properties addressList = bean.getAddressList();
		
		
			/*
			 * for (String address : addressList) { System.out.println(address); }
			 */ 
		
			
		 
		 
		
		  for (Object key : addressList.keySet()) {
		  System.out.println(addressList.get(key)); }
		 
			 
		 
		
		
		
		factory.close();
		
	}

}
