package com.mlegeb.core;

/**
 * 数据处理者
 * @author Mine
 */
public class Massager {
	 private static Massager massager;

     private Massager() {
         
     }
     
     /**
      * 单例模式
      * @return
      */
     public static Massager Instance() {
         if (massager == null)
             return new Massager();
         return massager;
     }
}
