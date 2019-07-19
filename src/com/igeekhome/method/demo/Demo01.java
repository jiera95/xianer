package com.igeekhome.method.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * java.lang.reflect.Method
 * 
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName("com.igeekhome.bean.Person");
			// TODO：getMethods、getDeclaredMethods、getMethod
			// 获取某一个方法
			Method setAgeMethod = clazz.getDeclaredMethod("setAge", int.class);
			// 1.获取访问修饰符
			System.out.println(Modifier.toString(setAgeMethod.getModifiers()));
			// 2.获取返回类型
			System.out.println(setAgeMethod.getReturnType());
			System.out.println(setAgeMethod.getReturnType() == void.class);
			// 3.参数列表
			System.out.println(Arrays.toString(setAgeMethod.getParameterTypes()));
			// 4.通过Method对象调用方法=>实例变量.方法名(参数列表)

			Object obj = clazz.newInstance();
			// 如果结果是null，有两种情况（1）方法有指定的返回类型，但是返回null（2）方法返回类型为void
			Object result = setAgeMethod.invoke(obj, 21);
			System.out.println(result);
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
