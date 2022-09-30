package com.zlabs;

import java.text.ParseException;

public class PaymentAppCreation {
	public static void main(String args[])
	{
		PaymentApp payment=new PaymentApp();
		try {
			payment.addUser();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
