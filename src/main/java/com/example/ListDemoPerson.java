package com.example;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/list")
public class ListDemoPerson {

	// inject the template as ListOperations
    // can also inject as Value, Set, ZSet, and HashOperations
	@Resource(name="redisTemplate")
    private ListOperations<String, Person> listOpsPerson;
    
    private static final String PERSON_STORE = "list.demo.person";
    
	
	@RequestMapping("/popPersonFromList")
	public Person popFromList(){
		return listOpsPerson.rightPop(PERSON_STORE);
	}
	
	@RequestMapping("/addPersonToList")
	public String addPersonToList(@RequestParam(value="name") String name, @RequestParam(value="age") String age){
		Person person = new Person(name, Integer.valueOf(age));
		listOpsPerson.leftPush(PERSON_STORE, person);
		
		return "Added " + person + " to list";
	}
}
