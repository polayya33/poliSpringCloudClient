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
Hot Potato:
The Hot Potato is the anti-pattern that describes when a messaging server continues to send a message that cannot be acknowledged by a consumer because the transaction keeps failing.
Problem:
 Messaging servers redeliver messages until they receive an acknowledgement from a consumer. 
 A transaction that rolls back on each attempt may not acknowledge the message, causing a continuous resend (loop). 
Symptoms and Consequences:
 This is an infinite loop. 
 The system shows high utilization but low throughput. 
Solution:
 If a transaction rolls back, acknowledge the message and forward it through another means (e-mail or to an error destination) for problem resolution. 
 Implement a resend threshold on the messaging server. When the threshold is reached, reassign the message to a dead-letter queue. 

	 
Cacheless Cow:
The Cacheless Cow is the anti-pattern that describes when frequently retrieved, but seldom changed, resources are not placed in a cache.
Problem:
When fairly static resources are repeatedly used without a caching strategy in place, then server and network resources are over-utilized (wasted).

Symptoms and Consequences:
 Scalability is constrained by the per-request round trips between the container and the external resource.
	
Forces:
A stored result may suffice for as many or more requests than when new data is needed.
A reasonable size for a cache can be determined from normal application use.
There is enough memory to cache enough results to achieve a useful hit rate.
Fast concurrent reads can be satisfied while also protecting data as it is being modified.
Solution:
Java EE EntityManager provides built-in caching.
Consider a cache for other service boundaries where objects get reused:
On a client-facing web server
Between clients and web tier components
Between web and business tier components
Consider vendor-provided caching solutions.
Consider cache-oriented patterns such as Command (GoF).
	
	
}
