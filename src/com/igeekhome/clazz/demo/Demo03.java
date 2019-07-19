package com.igeekhome.clazz.demo;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.igeekhome.bean.Person;

/**
 * Class对象的常用API
 * 
 * @author Administrator
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName("com.igeekhome.bean.Person");
			// 1.获取类的访问修饰符
			// clazz.getModifiers()得到的是修饰符对应的数字编号
			System.out.println(clazz.getModifiers());
			// 如果要将修饰符对应的数字编号转成String，调用Modifier.toString();
			System.out.println("访问修饰符：" + Modifier.toString(clazz.getModifiers()));
			// 2.获取完整类名（包名+类名）
			System.out.println("完整类名：" + clazz.getName());
			// 3.获取简单类名(只有类名)
			System.out.println("简单类名：" + clazz.getSimpleName());
			// 4.创建对象
			// clazz.newInstance调用的其实是类中的无参构造（前提是访问权限是足够的）
			Person p1 = (Person) clazz.newInstance();
			System.out.println(p1);

			Person p2 = getInstance("com.igeekhome.bean.Person");
			System.out.println(p2);

			// 5.判断是否为基本类型
			System.out.println(String.class.isPrimitive());
			System.out.println(int.class.isPrimitive());
			System.out.println(new int[] {}.getClass().isPrimitive());
			// void也是基本类型
			System.out.println(void.class.isPrimitive());

			// 6.判断是否为数组
			System.out.println(new int[] {}.getClass().isArray());
			System.out.println(new ArrayList<>().getClass().isArray());
			System.out.println(isCollection(new HashMap<>().getClass()));
			System.out.println(isCollection(new HashSet<>().getClass()));
			System.out.println(isCollection(new ArrayList<>().getClass()));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 实例化异常
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		// 非法访问异常
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static <T> T getInstance(String className) {
		try {
			return (T) Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 判断是否为集合
	 * 
	 * @return
	 */
	public static boolean isCollection(Class<?> clazz) {
		// 是List，是Map，是Set都应该返回true
		try {
			// 是集合的实例
			Object obj = clazz.newInstance();
			if (obj instanceof Collection || obj instanceof Map) {
				return true;
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return false;
	}
}
