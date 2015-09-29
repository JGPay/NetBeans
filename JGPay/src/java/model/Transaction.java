package model;

import java.util.Date;

public class Transaction {
	private Date date;
	private String card;
	private double amount;
	private int password;
	private String posIP;
	
	public Transaction(Date date, String card, int password, double amount, String posIP){
		setDate(date);
		setCard(card);
		setPassword(password);
		setAmount(amount);
		setPosIP(posIP);
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public String getCard(){
		return this.card;
	}
	
	public void setCard(String card){
		this.card = card;
	}
	
	public double getAmount(){
		return this.amount;
	}
	
	public void setAmount(double amount){
		this.amount = amount ;
	}
	
	public int getPassword(){
		return this.password;
	}
	
	public void setPassword(int password){
		this.password = password;
	}
	
	public String getPosIP(){
		return this.posIP;
	}
	
	public void setPosIP(String posIP){
		this.posIP = posIP;
	}

}