package com.dongchen.factory.simpleFactory;

/**
 * @ClassName TestSimpleFactory
 * @Description
 * @Author Dong_chen
 * @Date 2019-2-28 11:20
 * @Version 1.0
 */
public class TestSimpleFactory {

	public static void main(String[] args) {
		SimpleFactory simpleFactory = new SimpleFactory();
		Parent son01 = simpleFactory.getSon("son01");
		son01.method();
	}

}
