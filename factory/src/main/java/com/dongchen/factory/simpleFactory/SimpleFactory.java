package com.dongchen.factory.simpleFactory;

/**
 * @ClassName factory
 * @Description
 * @Author Dong_chen
 * @Date 2019-2-28 11:13
 * @Version 1.0
 */
public class SimpleFactory {

	public Parent getSon(String type){
		if ("son01".equals(type)){
			return new Son01();
		}else if ("son02".equals(type)){
			return new Son02();
		}else {
			return null;
		}
	}


}
