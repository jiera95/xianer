package com.igeekhome.clazz.demo;

import java.util.LinkedList;
import java.util.List;

/**
 * 类中的泛型E,K,V,T……在编译的时候会根据实际给定的类型，将代码中这些对应的类型进行自动取代（擦除）
 * 
 * @author Administrator
 *
 * @param <E>
 * @param <T>
 */
// 可以同时指定多个E,K,V,T……等类型，例如Map中就有两个
public class Stack<E> {
	private List<E> list;

	public Stack(List<E> list) {
		this.list = list;
	}

	/**
	 * 入栈
	 * 
	 * @return 返回入栈的元素
	 */
	public E push(E e) {
		return null;
	}

	/**
	 * 出栈
	 * 
	 * @return 返回出栈的元素
	 */
	public E pop() {
		return null;
	}

	/**
	 * 泛型方法 如果某个泛型不是类上有的泛型，则需要在该方法上声明当前方法持有的泛型
	 * 
	 * @param <T>
	 * 
	 * @param args
	 */

	public static <T> T getByIndex(int index) {
		T t = null;
		return null;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack(new LinkedList<Integer>());
		int i = stack.push(1);
		int ii = stack.pop();

		Stack<String> stack2 = new Stack(new LinkedList<String>());
		String s = stack2.push("1");
		String ss = stack2.pop();

		// 如果方法中声明了泛型，则最后在调用方法时，泛型方法中的泛型就会被接收返回值的变量类型所取代
		Object obj1 = getByIndex(1);
		int obj2 = getByIndex(2);
		double obj3 = getByIndex(3);
		getByIndex(3);
	}

}
