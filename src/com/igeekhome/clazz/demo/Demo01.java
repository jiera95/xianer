package com.igeekhome.clazz.demo;

import com.igeekhome.bean.Person;

/**
 * Class对象的获取方式
 * 
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {

		try {
			// 1.Class.forName("类的全局限定名")
			// 全局限定名=包名+类名
			// 通过全局限定名进行获取时，编译期间其实是不知道当前这个Class对应的是什么类型
			// 只有当程序运行以后，真正去加载了，才能确定下来

			Class<?> c1 = Class.forName("com.igeekhome.bean.Person");
			System.out.println(c1);

			// 2. 类名.class
			// 已经确定下来就是Person类型，所以泛型就是Person
			Class<Person> c2 = Person.class;
			System.out.println(c2);

			// 3.对象实例.getClass();
			// 因为实例是在运行以后才有的，所以运行前依然无法确定
			Class<?> c3 = new Person().getClass();
			System.out.println(c3);

			// 4.通过类加载器获取（了解）
			// 通过全局限定名进行获取时，编译期间其实是不知道当前这个Class对应的是什么类型
			// 只有当程序运行以后，真正去加载了，才能确定下来
			Class<?> c4 = Demo01.class.getClassLoader().loadClass("com.igeekhome.bean.Person");
			System.out.println(c4);

			System.out.println(c1 == c2);
			System.out.println(c2 == c3);
			System.out.println(c3 == c4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
