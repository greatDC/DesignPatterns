package com.dongchen.cglib;

/**
 * @ClassName TestCglibProxy
 * @Description
 * @Author Dong_chen
 * @Date 2019-2-28 9:50
 * @Version 1.0
 */
public class TestCglibProxy {

	public static void main(String[] args) {
		Celebrity tom = (Celebrity)new Broker().newInstance(new Celebrity("Tom").getClass());
		tom.speak();
	}

}
