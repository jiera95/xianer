package com.igeekhome.bean;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 7355577546895629933L;
	private String name;
	protected int age;
	public int gender;
	String birthDate;

	static {
		System.out.println("静态代码块...");
	}
	{
		System.out.println("构造代码块...");
	}

	public Person() {
		System.out.println("无参构造方法...");
	}

	public Person(String name, int age) {

		this.name = name;
		this.age = age;
	}

	Person(int age, String name) {
		super();
		this.name = name;
		this.age = age;
	}

	protected Person(int age) {
		super();
		this.age = age;
	}

	private Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//
	// public void setAge(Integer age) {
	// this.age = age;
	// }

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", birthDate=" + birthDate + "]";
	}

}
