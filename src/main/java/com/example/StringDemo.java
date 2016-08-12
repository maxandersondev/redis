package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/string")
public class StringDemo {
	
	@Autowired
	private StringRedisTemplate template;
	
	@RequestMapping("/stringSetter")
	public String stringSetter(@RequestParam(value="stringIn") String stringIn){
		ValueOperations<String, String> ops = this.template.opsForValue();
		String key = "spring.boot.redis.test";
		if (!this.template.hasKey(key)) {
			ops.set(key, stringIn);
		}
		return "Set string: " + stringIn;
	}
	
	@RequestMapping("stringGetter")
	public String stringGetter(){
		ValueOperations<String, String> ops = this.template.opsForValue();
		String key = "spring.boot.redis.test";
		return "Found key " + key + ", value=" + ops.get(key);
	}

}
