package com.restful.bean;

import javax.ws.rs.QueryParam;

public class ParamBeanClass {

	 private @QueryParam("valueA") int valueA;
	 private @QueryParam("valueB") int valueB;
	 private @QueryParam("valueC") int valueC;
	 
	 
	public int getValueA() {
		return valueA;
	}
	public void setValueA(int valueA) {
		this.valueA = valueA;
	}
	public int getValueB() {
		return valueB;
	}
	public void setValueB(int valueB) {
		this.valueB = valueB;
	}
	public int getValueC() {
		return valueC;
	}
	public void setValueC(int valueC) {
		this.valueC = valueC;
	}
}
