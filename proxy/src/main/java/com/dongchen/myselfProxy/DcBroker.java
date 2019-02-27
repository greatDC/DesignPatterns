package com.dongchen.myselfProxy;

import com.dongchen.jdk.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName Broker
 * @Description This is
 * @Author Dong_chen
 * @Date 2019-2-27 10:47
 * @Version 1.0
 */
public class DcBroker implements DcInvocationHandler {

	private Person target;

	public Object newInstance(Person target){
		this.target = target;
		Class clazz = target.getClass();
		return DcProxy.newProxyInstance(new DcClassLoader(),clazz.getInterfaces(),this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Proxy start");
		method.invoke(this.target,args);
		System.out.println("Proxy end");
		return null;
	}

}
