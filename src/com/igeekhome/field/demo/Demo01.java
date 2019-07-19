package com.igeekhome.field.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * java.lang.reflect.Field
 * 
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName("com.igeekhome.bean.Person");
			// 1.获取所有的属性
			// (1)如果就是某一个父类（没有继承过其它类），则得到其中公有属性
			// 如果是子类，得到子类和父类中的公有属性
			Field[] fields1 = clazz.getFields();
			System.out.println(Arrays.toString(fields1));
			// (2)如果就是某一个父类（没有继承过其它类），则得到其中所有属性
			// 获取子类中的所有属性
			Field[] fields2 = clazz.getDeclaredFields();
			System.out.println(Arrays.toString(fields2));

			// 2.获取某一个属性
			Field genderField = clazz.getDeclaredField("gender");
			Field nameField = clazz.getDeclaredField("name");
			// clazz.getField("");

			// 3.修改属性的值 =>实例变量.set(要设置的值)
			// 第一个参数：实例
			// 第二个参数：要设置的值
			Object person1 = clazz.newInstance();
			genderField.set(person1, 1);
			System.out.println(person1);
			nameField.setAccessible(true);
			nameField.set(person1, "Tom");
			nameField.setAccessible(false);
			System.out.println(person1);

			// 4.获取属性的访问修饰符
			System.out.println(Modifier.toString(genderField.getModifiers()));

			// 5.获取属性的类型
			System.out.println(genderField.getType());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
