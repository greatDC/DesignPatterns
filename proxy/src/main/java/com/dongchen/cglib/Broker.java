package com.dongchen.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName Broker
 * @Description
 * @Author Dong_chen
 * @Date 2019-2-28 9:49
 * @Version 1.0
 */
public class Broker implements MethodInterceptor {

	public Object newInstance(Class clazz){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("******AOP start******");
		methodProxy.invokeSuper(object,args);
		System.out.println("******AOP end*******");
		return null;
	}
}
