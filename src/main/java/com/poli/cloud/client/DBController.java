package com.poli.cloud.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBController {

	
	@Value("${driverClass}")
	private String driverClass;
	@Value("${url}")
	private String url;
	@Value("${userName}")
	private String userName;
	@Value("${password}")
	private String password;
	
	@RequestMapping(value="/db",method=RequestMethod.GET)
	public String getDBDetails(){
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("driverClass", driverClass);
		map.put("url", url);
		map.put("userName", userName);
		map.put("driverClass", userName);
		return map.toString();
		
	}
}
