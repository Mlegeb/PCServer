package com.mlegeb.config;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 名称: ConfigPoco.java
 * 描述: PC端配置基类     实现序列化
 *
 * @author a_xiang
 * @version v1.0
 * @created 2015年1月20日
 */
public class ConfigPoco implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 将配置类序列化后保存到文件
	 * @param fileName 文件名
	 */
	public  void saveConfig(String fileName){

		ObjectOutputStream oo;
		try {
			oo = new ObjectOutputStream(new FileOutputStream(
					new File(fileName)));
			oo.writeObject(this);
			System.out.println("配置信息保存成功！");
			oo.close();
		} catch (Exception e) {
			System.out.println("配置信息保存失败！");
			e.printStackTrace();
		}


	}

	/**
	 * 读取文件中序列化保存的配置类
	 * @param fileName
	 * @return Object 配置类
	 */
	@SuppressWarnings("resource")
	public Object getConfig(String fileName){
		ObjectInputStream ois;
		Object object = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(
					new File(fileName)));
			object = ois.readObject();
			System.out.println("配置信息读取成功！");
		
		} catch (Exception e) {
			System.out.println("配置信息读取失败！");
			e.printStackTrace();
		}
		return object;
	}
}
