package com.igeekhome.constructor.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import com.igeekhome.bean.Person;

/**
 * java.lang.reflect.Constructor
 * 
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName("com.igeekhome.bean.Person");
			// 1.获取类中的所有构造方法
			// (1)获取所有public修饰的构造方法
			Constructor<?>[] constructors1 = clazz.getConstructors();
			System.out.println(Arrays.toString(constructors1));
			// (2)获取任何修饰符修饰的构造方法
			Constructor<?>[] constructors2 = clazz.getDeclaredConstructors();
			System.out.println(Arrays.toString(constructors2));

			// 2.获取某一个构造方法
			// (1)获取public修饰的构造方法
			Constructor<?> c1 = clazz.getConstructor(String.class, int.class);
			System.out.println(c1);
			// (2)获取任何修饰符修饰的构造方法
			Constructor<?> c2 = clazz.getDeclaredConstructor(String.class);
			System.out.println(c1);

			// 3.创建对象
			Person p1 = (Person) c1.newInstance("Tom", 18);
			System.out.println(p1);

			// 打破封装以后调用私有构造器
			c2.setAccessible(true);
			Person p2 = (Person) c2.newInstance("Jack");
			// 调用完毕以后重新封装回去
			c2.setAccessible(false);
			System.out.println(p2);

			// 4.获取构造器的访问修饰符
			System.out.println(Modifier.toString(c2.getModifiers()));

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
