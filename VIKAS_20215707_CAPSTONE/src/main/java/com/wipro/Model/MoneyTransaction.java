package com.wipro.Model;

import lombok.Data;

@Data
public class MoneyTransaction {
	
	private long fromAccNum;
	private long toAccNum;
	private double amount;
	public long getFromAccNum() {
		return fromAccNum;
	}
	public void setFromAccNum(long fromAccNum) {
		this.fromAccNum = fromAccNum;
	}
	public long getToAccNum() {
		return toAccNum;
	}
	public void setToAccNum(long toAccNum) {
		this.toAccNum = toAccNum;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
