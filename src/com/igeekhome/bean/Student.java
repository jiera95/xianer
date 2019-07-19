package com.igeekhome.bean;

import java.io.Serializable;

public class Student extends Person implements Serializable {

	private static final long serialVersionUID = -2848149300564028386L;
	private String dept;
	public int deptNo;

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

}
