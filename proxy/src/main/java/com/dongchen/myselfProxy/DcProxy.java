package com.dongchen.myselfProxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName DcProxy
 * @Description
 * @Author Dong_chen
 * @Date 2019-2-27 13:38
 * @Version 1.0
 */
public class DcProxy {

	private static String ln = "\r\n";

	public static Object newProxyInstance(DcClassLoader loader,
										  Class<?>[] interfaces,
										  DcInvocationHandler h) throws IllegalArgumentException {
		System.out.println("********genenrate proxy start*********");
		//1.生成proxy
		String proxySrc = generateSrc(interfaces[0]);

		//2.输出.java
		String path = DcProxy.class.getResource("").getPath();
		File file = new File(path);
		FileWriter out = null;
		try {
			out = new FileWriter(file);
			out.write(proxySrc);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		//3.编译class
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(null, null, null);
		Iterable<? extends JavaFileObject> iterable = standardFileManager.getJavaFileObjects(file);
		JavaCompiler.CompilationTask task = compiler.getTask(null, standardFileManager, null, null, null, iterable);
		task.call();
		try {
			standardFileManager.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


		//将class文件中的内容动态加载到JVM中,并生成代理对象
		try {
			Class<?> proxyClass = loader.findClass("$Proxy0");
			Constructor<?> constructor = proxyClass.getConstructor(DcInvocationHandler.class);
			return constructor.newInstance(h);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println("********genenrate proxy end*********");


		return null;
	}

	private static String generateSrc(Class<?> interfaces) {
		StringBuffer src = new StringBuffer();
		src.append("package com.dongchen.myselfProxy;" + ln);
		src.append("import java.lang.reflect.Method;" + ln);
		src.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);

		src.append("DcInvocationHandler h;" + ln);

		src.append("public $Proxy0(DcInvocationHandler h) {" + ln);
		src.append("this.h = h;" + ln);
		src.append("}" + ln);

		for (Method m : interfaces.getMethods()) {
			src.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + ln);

			src.append("try{" + ln);
			src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
			src.append("this.h.invoke(this,m,null);" + ln);
			src.append("}catch(Throwable e){e.printStackTrace();}" + ln);
			src.append("}" + ln);
		}

		src.append("}");


		return null;
	}

}
