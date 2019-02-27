package com.dongchen.jdk;

/**
 * @ClassName Celebrity
 * @Description
 * @Author Dong_chen
 * @Date 2019-2-27 10:47
 * @Version 1.0
 */
public class Celebrity implements Person{

	private String name ;

	public Celebrity(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void speak() {
		System.out.println("********start********");
		System.out.println("My name is :" + name);
		System.out.println("********end**********");
	}
}
