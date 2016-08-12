package com.example;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/list")
public class ListDemo {

	// inject the template as ListOperations
    // can also inject as Value, Set, ZSet, and HashOperations
    @Resource(name="redisTemplate")
    private ListOperations<String, String> listOpsString;
    
    private static final String STRING_STORE = "list.demo.string";
    
	@RequestMapping("/addToList")
	public String addToList(@RequestParam(value="name") String name){
		
		listOpsString.leftPush(STRING_STORE, name);
		return "Added " + name + " to list!";
	}
	
	@RequestMapping("/popFromList")
	public String popFromList(){
		return listOpsString.rightPop(STRING_STORE);
	}
	
	
}
