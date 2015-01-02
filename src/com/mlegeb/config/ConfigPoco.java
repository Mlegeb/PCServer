package com.mlegeb.config;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 程序配置序列化 
 * @author Mine
 */
public class ConfigPoco implements Serializable {

	private static final long serialVersionUID = 1L;

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
