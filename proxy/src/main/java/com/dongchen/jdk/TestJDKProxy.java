package com.dongchen.jdk;

/**
 * @ClassName TestJDKProxy
 * @Description
 * @Author Dong_chen
 * @Date 2019-2-27 10:47
 * @Version 1.0
 */
public class TestJDKProxy {

	public static void main(String[] args) {
		Person tom = (Person)new Broker().newInstance(new Celebrity("Tom"));
		tom.speak();
		System.out.println(tom.getClass());
	}

}
