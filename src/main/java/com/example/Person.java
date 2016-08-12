package com.example;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5768896963543719921L;
	
	private String name;
	private int age;

	@Override
	public String toString(){
		return "Person -> name: " + name + " age:" + age;
	}
}
