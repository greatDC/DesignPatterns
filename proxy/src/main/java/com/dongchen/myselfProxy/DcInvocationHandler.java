package com.dongchen.myselfProxy;

import java.lang.reflect.Method;

/**
 * @ClassName DcIvocationHandler
 * @Description
 * @Author Dong_chen
 * @Date 2019-2-27 13:37
 * @Version 1.0
 */
public interface DcInvocationHandler {

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable;

}
