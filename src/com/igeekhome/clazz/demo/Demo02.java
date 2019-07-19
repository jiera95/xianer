package com.igeekhome.clazz.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * ?
 * 
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		// 上边界通配符? extends xxx
		// 其中的元素必须是Number或其子类型
		List<? extends Number> list1 = new ArrayList<Number>();
		List<? extends Number> list2 = new ArrayList<Integer>();
		List<? extends Number> list3 = new ArrayList<Double>();

		// 下边界通配符? super xxx
		// 其中的元素是Number或其父类型
		List<? super Number> list4 = new ArrayList<Number>();
		// 因为Integer，Double不是Number的父类型，所以不正确
		// List<? super Number> list5 = new ArrayList<Integer>();
		// List<? super Number> list6 = new ArrayList<Double>();
		list4.add(1);
		list4.add(1.0);

	}
}
