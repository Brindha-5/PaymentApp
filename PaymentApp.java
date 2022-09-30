package com.zlabs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentApp {
	Scanner input=new Scanner(System.in);
	ArrayList<UserPojo> user_registration=new ArrayList<>();
	ArrayList<BankDetailsPojo> bank_details=new ArrayList<>();
	ArrayList<TransactionLogsPojo> transaction_log=new ArrayList<>();
	public void welcomePage()
	{
		
	 System.out.println("******* Welcome to ZOHO Payment App  ********");
		System.out.println("1.Register");
		System.out.println("2.Login");
		System.out.println("Enter your choice");
		int choice=input.nextInt();
		switch(choice)
		{
		case 1:
			userRegistration();
			
			break;
		case 2:
			userLogin();
			break;
		default:
			System.out.println("Enter valid choice");
			}
	}
	
	 boolean passWordVerification(String password) {
		if (password == null) {
	        return false;
	    }
		int count=0;
		String testPassword = password.toLowerCase();
		for(int i=0;i<testPassword.length();i++) {
			count=0;
			char index = testPassword.charAt(i);
			for(int j=0;j<testPassword.length();j++) {
				if(i==j) {
					continue;
				}
				char indexNext = testPassword.charAt(j);
				if(index==indexNext) {
					count++;
				}
				if(count >3) {
					return false;
				}
			}
		}
		String regex = "^(?=.*[0-9])"
	            + "(?=.*[A-Z])"
	            + "(?=.*[@#$%^&+=])"
	            + ".{8,}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);
		return m.matches();
	}
	 
	 public void addUser()
	 {
		 //user_registration.add(101,new UserPojo("brindha","br@gmail.com","kio*7Yjkl"));
		 user_registration.add(new UserPojo("brindha","br@gmail.com","kio*7Yjkl"));
		 user_registration.add(new UserPojo("akila","ak@gmail.com","pio*7Yjkl"));
		 user_registration.add(new UserPojo("pooja","po@gmail.com","uio*7Yjyj"));
		 user_registration.add(new UserPojo("elakkiya","el@gmail.com","uio*7uytkl"));
		 user_registration.add(new UserPojo("sreeja","sr@gmail.com","uio*7Yjklop"));
		 welcomePage();
		 
	 }
	 public void userRegistration()
	 {
		 String name,mail_id,password;
			int referral_code,invite_code,ref_option;
		boolean reg=true;
		 System.out.println("Enter Your Name");
			name=input.next();
			System.out.println("Enter your mail id");
			mail_id=input.next();
			for(int i=0;i<user_registration.size();i++)
			{
				if(user_registration.get(i).getMail_id().equals(mail_id))
				{
					System.out.println("Your account is already Registered..Please login");
					reg=false;
				}
			}
			
		/*	System.out.println("Do you have any referral code if yes press 1,no press 0");
			ref_option=input.nextInt();
			if(ref_option==1)
			{
				System.out.println("Enter Referral code");
				referral_code=input.nextInt();
			}*/
			if(reg)
			{
			System.out.println("Enter your password");
			password=input.next();
			
			boolean valid=passWordVerification(password);
			if(valid)
			{
				//System.out.println("valid");
				//System.out.println("Enter your invite_code");
				//invite_code=input.nextInt();
				user_registration.add(new UserPojo(name,mail_id,password));
				System.out.println("User Registration is successfully Completed");
				
		 }
			else
			{
				System.out.println("Your Password Strength is weak...please try again");
				//userRegistration();
			}
			}
			System.out.println("Do you want to continue 1-yes/0-No");
			int option_continue=input.nextInt();
			if(option_continue==1)
			{
				welcomePage();
			}
			
		}
	 public void userLogin()
	 {
		 String mailid,password;
		 boolean login=true;
		 System.out.println("*******Login Page********");
		 System.out.println("Enter Email_Id");
		 mailid=input.next();
		 System.out.println("Enteryour password");
		 password=input.next();
		 
		 for(int i=0;i<user_registration.size();i++)
			{
				if(user_registration.get(i).getMail_id().equals(mailid)&&user_registration.get(i).getPassword().equals(password))
				{
					System.out.println("You are Logged in Successfully");
					login=false;
					userMenu(mailid);
				}
				
		 }
		 if (login)
		 {
			 System.out.println("Please check your mailid & password or kindly register");
			 System.out.println("Do you want to continue 1-yes/0-No");
				int option_continue=input.nextInt();
				if(option_continue==1)
				{
					welcomePage();
				}
		 }
		
	 }
	 public void userMenu(String mailid)
	 {
		 System.out.println("**********************************");
		 System.out.println("1.Bank Accounts");
		 System.out.println("2.Pay");
		 System.out.println("3.Invites");
		 System.out.println("4.Transaction");
		 System.out.println("5.Display all Details");
		 System.out.println("6.Logout");
		 System.out.println("Enter your choice");
		 int choice=input.nextInt();
		 switch(choice)
		 {
		 case 1:
			 toAddBankAccount(mailid);
			 break;
		 case 2:
			 toPay(mailid);
			 break;
		 }
		 
	 }
	 public void toAddBankAccount(String mailid)
	 {
		 System.out.println("***************************************");
		 System.out.println("1.Add Account");
		 System.out.println("2.Check Balance");
		 System.out.println("3.Add Money");
		 System.out.println("4.Remove Account");
		 System.out.println("5.Go Back");
		 System.out.println("Enter your choice");
		 int choice=input.nextInt();
		 switch(choice)
		 {
		 case 1:
			 toAddAccountDetails(mailid);
			 break;
		 case 2:
			 toCheckBalance(mailid);
			 break;
		 case 3:
			 toAddMoney(mailid);
			 break;
		 case 4:
			 toRemoveAccount(mailid);
			 break;
		 case 5:
			 userMenu(mailid);
			 break;
		 default:
			 System.out.println("Please check your choice");
			 toAddBankAccount(mailid);
			 
		 }
	 }
	 public void toAddAccountDetails(String mailid)
	 {
		 String acc_no,IFSC_code,display_name,bank_name,upi_id;
		  double balance;
		  boolean acc_valid=true;
		 System.out.println("*********************************************");
		 System.out.println("Enter your account number");
		 acc_no=input.next();
		 for(int i=0;i<bank_details.size();i++)
		 {
			 if(bank_details.get(i).getAcc_number().equals(acc_no))
			 {
				 System.out.println("This account number is already registered");
				 acc_valid=false;
			 }
		 }
		 if(acc_valid)
		 {
		 System.out.println("Enter your IFSC Code");
		 IFSC_code=input.next();
		 System.out.println("Enter your Display name");
		 display_name=input.next();
		 
		 for(int i=0;i<bank_details.size();i++)
		 {
			 if(bank_details.get(i).getDisplay_name().equals(display_name))
			 {
				 System.out.println("Please try with different name");
				 toAddAccountDetails(mailid);

			 }
		 }
		 System.out.println("Enter your Bank name");
		 bank_name=input.next();
		 System.out.println("Enter your account balance");
		 balance=input.nextDouble();
		 upi_id=display_name+"@"+bank_name;
		 System.out.println("Your UPI_ID is"+upi_id);
		 bank_details.add(new BankDetailsPojo(mailid,acc_no,IFSC_code,bank_name,display_name,upi_id,balance));
		 System.out.println("Your Account is Added Successfully");
		 System.out.println("Do you want to continue yes-1/no-0");
		 int con=input.nextInt();
		 if(con==1)
		 {
			 userMenu(mailid);
		 }
		 else {
			 System.out.println("Thanks for using our App");
		 }
		 
		 
		 
		 }
	 }
	 public void toCheckBalance(String mailid)
	 {
		 String acc_no;
		 System.out.println("Enter your Account number to check balance");
		 acc_no=input.next();
		 boolean flag=true;
		 for(int i=0;i<bank_details.size();i++)
		 {
			 if(bank_details.get(i).getAcc_number().equals(acc_no)&&bank_details.get(i).getMailid().equals(mailid))
			 {
				 System.out.println("Your available balance is :"+bank_details.get(i).getBalance());
				 flag=false;
				 toAddBankAccount(mailid);
				 
			 }
		 }
		 if(flag)
		 {
			 System.out.println("Please check your account number");
			
			 toAddBankAccount(mailid);
		 }
		 
	 }
	 public void toAddMoney(String mailid)
	 {
		 String acc_no;
		 double amount,balance=0;
		  
		 System.out.println("Enter the Account number");
		 acc_no=input.next();
		 boolean flag=false;
		 for(int i=0;i<bank_details.size();i++)
		 {
			 if(bank_details.get(i).getAcc_number().equals(acc_no)&&bank_details.get(i).getMailid().equals(mailid))
			 {
				flag=true;
				balance=bank_details.get(i).getBalance();
				
			 }
		 }
		 if(flag)
		 {
			 System.out.println("Enter the amount to add in your account");
			 amount=input.nextDouble();
			 balance=balance+amount;
			
			 for(int i=0;i<bank_details.size();i++)
			 {
				 if(bank_details.get(i).getAcc_number().equals(acc_no)&&bank_details.get(i).getMailid().equals(mailid))
				 {
					bank_details.get(i).setBalance(balance);
					
				 }
			 }
			 System.out.println("The amount is successfully added to your account");
			 System.out.println("The current balance in your account is"+balance);
			 Date date = new Date();
		      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		       String datestr= formatter.format(date);
		       transaction_log.add(new TransactionLogsPojo(mailid,acc_no,"Deposit",amount,datestr));
		       toAddBankAccount(mailid);
			 
			 
		 }
		 else
		 {
			 System.out.println("Please check your account number");
			 userMenu(mailid);
		 }
		 
		 
	 }
	 public void toRemoveAccount(String mailid)
	 {
		 String acc_no;
		 
	System.out.println("Enter the Account number");
		 acc_no=input.next();
		 boolean flag=false;
		 for(int i=0;i<bank_details.size();i++)
		 {
			 if(bank_details.get(i).getAcc_number().equals(acc_no)&&bank_details.get(i).getMailid().equals(mailid))
			 {
				bank_details.remove(i);
				flag=true;
				
			 }
	 }
		 if(flag)
		 {
			 System.out.println("The account is removed successfully");
		 }
		 else {
			 System.out.println("Account doesnt exist");
		 }
	 
}
public void toPay(String mailid)
{
	System.out.println("************************************");
	System.out.println("Select your Payment method");
	System.out.println(	"1.Pay via UPI");
	System.out.println("2.Pay via BankAccount");
	System.out.println("3.Go back");
	System.out.println("Enter your choice");
	int choice=input.nextInt();
	
switch(choice)
{
case 1:
	payViaUPI(mailid);
	break;
case 2:
	payViaBankAccount(mailid);
	break;
case 3:
	userMenu(mailid);
	break;
case 4:
	System.out.println("Please check your option");
	
}
}
public void payViaUPI(String mailid)
{
	String acc_no,upi_id,bank_acc,ifsc_code;
	double amt,balance=0;
	
	System.out.println("*********************************************");
	System.out.println("Enter your account number");
	acc_no=input.next();
	System.out.println("Enter the amount to pay");
	 amt=input.nextDouble();
	  boolean flag=false;
	 for(int i=0;i<bank_details.size();i++)
	 {
		 if(bank_details.get(i).getAcc_number().equals(acc_no)&&bank_details.get(i).getMailid().equals(mailid))
		 {
			 flag=true;
			 if(bank_details.get(i).getBalance()<amt)
			 {
				 System.out.println("You are not having sufficient amount to pay");
				 userMenu(mailid);
			 }
			 else
			 {
				 balance=balance=bank_details.get(i).getBalance();
				 balance=balance-amt;
				 bank_details.get(i).setBalance(balance);
			 }
		 }
	 }
	 Date date = new Date();
     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
      String datestr= formatter.format(date);
	 if(flag)
	 {
		 System.out.println("Enter UPI_ID");
		 upi_id=input.next();
		 boolean  upi=true;
		 for(int i=0;i<bank_details.size();i++)
		 {
			 if(bank_details.get(i).getUpi_id().equals(upi_id))
			 {
				 upi=false;
				 balance=bank_details.get(i).getBalance();
				 balance=balance+amt;
				 bank_details.get(i).setBalance(balance);
				 System.out.println("Successfully paid");
				 
			     transaction_log.add(new TransactionLogsPojo(mailid,acc_no,"pay via upi",amt,datestr));
			     toAddBankAccount(mailid);
			 }
		 }
		 
		if(upi)
		{
			System.out.println("Successfully paid");
			 transaction_log.add(new TransactionLogsPojo(mailid,acc_no,"pay via upi",amt,datestr));
			 toAddBankAccount(mailid);
		}
		 
		 }
}
public void payViaBankAccount(String mailid)
{
	String acc_no,bank_acc,ifsc_code;
	double amt,balance=0;
	
	System.out.println("*********************************************");
	System.out.println("Enter your account number");
	acc_no=input.next();
	System.out.println("Enter the amount to pay");
	 amt=input.nextDouble();
	  boolean flag=false;
	 for(int i=0;i<bank_details.size();i++)
	 {
		 if(bank_details.get(i).getAcc_number().equals(acc_no)&&bank_details.get(i).getMailid().equals(mailid))
		 {
			 flag=true;
			 if(bank_details.get(i).getBalance()<amt)
			 {
				 System.out.println("You are not having sufficient amount to pay");
				 userMenu(mailid);
			 }
			 else
			 {
				 balance=balance=bank_details.get(i).getBalance();
				 balance=balance-amt;
				 bank_details.get(i).setBalance(balance);
			 }
		 }
	 }
	 Date date = new Date();
     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
      String datestr= formatter.format(date);
      System.out.println("Enter the account number");
      bank_acc=input.next();
      System.out.println("Enter the IFSC_code");
      ifsc_code=input.next();
      boolean acc_flag=true;
      for(int i=0;i<bank_details.size();i++)
 	 {
 		 if(bank_details.get(i).getAcc_number().equals(bank_acc)&&bank_details.get(i).getIfsc_code().equals(ifsc_code))
 		 {
 			 acc_flag=false;
 			 balance=balance=bank_details.get(i).getBalance();
			 balance=balance+amt;
			 bank_details.get(i).setBalance(balance);
			 System.out.println("Successfully paid");
			 
		     transaction_log.add(new TransactionLogsPojo(mailid,acc_no,"pay via BankAccount number",amt,datestr));
		 }
	 }
	 
	if(acc_flag)
	{
		System.out.println("Successfully paid");
		 transaction_log.add(new TransactionLogsPojo(mailid,acc_no,"pay via BankAccount number",amt,datestr));
	}
	userMenu(mailid);
 		 
 	 }
      
	
}
	



