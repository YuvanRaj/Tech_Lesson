package com.angular.rest;

import java.util.List;

public class ExpenseVO {
	
	private String firstName;
	private int lastName;
	private List<ExpenseVO> expenseVO;
	
	public List<ExpenseVO> getExpenseVO() {
		return expenseVO;
	}
	public void setExpenseVO(List<ExpenseVO> expenseVO) {
		this.expenseVO = expenseVO;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getLastName() {
		return lastName;
	}
	public void setLastName(int lastName) {
		this.lastName = lastName;
	}
		
}
