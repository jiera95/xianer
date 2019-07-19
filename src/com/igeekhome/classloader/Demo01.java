package com.igeekhome.classloader;

import com.sun.glass.ui.ClipboardAssistance;

/**
 * 类加载器
 * 
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		// String的类加载器
		// BootStrap底层是通过C和C++实现的，所以不会返回Java对象
		ClassLoader c1 = "Hello".getClass().getClassLoader();
		System.out.println(c1);

		// Demo01的类加载器
		// 因为DEMO01是ClassPath下的类，所以是AppClassLoader
		ClassLoader c2 = Demo01.class.getClassLoader();
		System.out.println(c2);

		// ClipboardAssistance的类加载器
		// 注意：在com.sun包下的类不允许开发人员直接调用
		// 配置后可以调用：
		// BuildPath->Configure Build Path->Libraries->Access
		// Rules->Edit->Add->Accessible->**
		// ClipboardAssistance在扩展目录下，所以得到ExtClassLoader
		ClassLoader c3 = ClipboardAssistance.class.getClassLoader();
		System.out.println(c3);
	}
}
