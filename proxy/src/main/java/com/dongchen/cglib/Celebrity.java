package com.dongchen.cglib;

/**
 * @ClassName Celebrity
 * @Description
 * @Author Dong_chen
 * @Date 2019-2-28 9:15
 * @Version 1.0
 */
public class Celebrity {

	private String name ;

	public Celebrity(){
		super();
	}

	public Celebrity(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void speak(){
		System.out.println("My name is :"+this.name);
	}

}
