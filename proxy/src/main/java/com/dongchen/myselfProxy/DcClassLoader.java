package com.dongchen.myselfProxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName DcClassLoader
 * @Description
 * @Author Dong_chen
 * @Date 2019-2-27 15:22
 * @Version 1.0
 */
public class DcClassLoader extends ClassLoader{

	private File baseDir;

	public DcClassLoader() {
		String path = DcClassLoader.class.getResource("").getPath();
		this.baseDir = new File(path);
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String className = DcClassLoader.class.getPackage().getName()+"."+name;
		if (this.baseDir!=null){
			File classFile = new File(baseDir, name.replaceAll("//.", "/") + ".class");
			if (classFile.exists()){
				FileInputStream in = null;
				ByteArrayOutputStream out = null;
				try{
					in = new FileInputStream(classFile);
					out = new ByteArrayOutputStream();
					byte[] buf = new byte[1024];
					int len ;
					while((len = in.read(buf))!=-1){
						out.write(buf,0,len);
					}
					return defineClass(className,out.toByteArray(),0,out.size());
				}catch (Exception e){
					e.printStackTrace();
				}finally {
					if (in != null){
						try {
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (out != null){
						try {
							out.flush();
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

		return null;
	}
}
