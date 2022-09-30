package com.zlabs;

import java.text.ParseException;
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
	int codenum=1;
	public void welcomePage() throws ParseException
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
	 
	 public void addUser() throws ParseException
	 {
		 //user_registration.add(101,new UserPojo("brindha","br@gmail.com","kio*7Yjkl"));
		 user_registration.add(new UserPojo("brindha","br@gmail.com","kio*7Yjkl","br01"));
		 user_registration.add(new UserPojo("akila","ak@gmail.com","pio*7Yjkl","ak02"));
		 user_registration.add(new UserPojo("pooja","po@gmail.com","uio*7Yjyj","po02"));
		 user_registration.add(new UserPojo("elakkiya","el@gmail.com","uio*7uytkl","el05"));
		 user_registration.add(new UserPojo("sreeja","sr@gmail.com","uio*7Yjklop","sr08"));
		 bank_details.add(new BankDetailsPojo("br@gmail.com","abc123","abc","canarabank","bindhu","bindhu@canarabank",5000,0));
		 bank_details.add(new BankDetailsPojo("ak@gmail.com","ghj567","ghj","icicibank","aki","aki@icicibank",10000,0));
		 bank_details.add(new BankDetailsPojo("po@gmail.com","ads555","ads","Indianbank","poo","poo@Indianbank",6000,0));
		 bank_details.add(new BankDetailsPojo("el@gmail.com","uyw243","uyj","LVbank","ela","ela@LVbank",2000,0));
		 bank_details.add(new BankDetailsPojo("sr@gmail.com","jkl999","jkl","Mahindrabank","sree","sree@Mahindrabank",7000,0));
		 transaction_log.add(new TransactionLogsPojo("br@gmail.com","abc123","pay via BankAccount number",200,"22/08/27 09:29:58"));
		 transaction_log.add(new TransactionLogsPojo("ak@gmail.com","ghj567","pay via BankAccount number",500,"22/09/23 09:29:58"));
		 transaction_log.add(new TransactionLogsPojo("br@gmail.com","abc123","Deposit",700,"22/09/25 09:29:58"));
		 transaction_log.add(new TransactionLogsPojo("br@gmail.com","abc123","pay via UPI_ID",200,"22/08/25 09:29:58"));
		 welcomePage();
		 
	 }
	 public void userRegistration()
	 {
		 String name,mail_id,referral_code,invite_code,password,ref_mailid=null;
			int ref_option;
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
				System.out.println("Do you have any referral code if yes press 1,no press 0");
			ref_option=input.nextInt();
			if(ref_option==1)
			{
				System.out.println("Enter Referral code");
				referral_code=input.next();
				boolean ref_flag=false;
				for(int i=0;i<user_registration.size();i++)
				{
					if(user_registration.get(i).getInvite_code().equals(referral_code))
					{
						ref_flag=true;
						ref_mailid=user_registration.get(i).getMail_id();
					}
					if(ref_flag)
					{
						 for(int j=0;j<bank_details.size();j++)
						 {
							 if(bank_details.get(j).getMailid().equals(ref_mailid))
							 {
								double amt=bank_details.get(j).getBalance();
								int ref_amt=bank_details.get(j).getReward();
								bank_details.get(j).setReward(ref_amt+50);
								bank_details.get(j).setBalance(amt+50);
								break;
								 
							 }
						 }
						 break;
					}
				}
				
			}
			if(reg)
			{
			System.out.println("Enter your password");
			password=input.next();
			
			boolean valid=passWordVerification(password);
			if(valid)
			{
				
				System.out.println("User Registration is successfully Completed");
				String substring = name.substring(2);
				invite_code=substring+codenum++;
				user_registration.add(new UserPojo(name,mail_id,password,invite_code));
				
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
				try {
					welcomePage();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	 public void userLogin() throws ParseException
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
	 public void userMenu(String mailid) throws ParseException
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
		 case 3:
			 toInvite(mailid);
			 break;
		 case 4:
			 toViewTransactionHistory(mailid);
			 break;
		 case 5:
			 break;
		 case 6:
			 System.out.println("Thanks for Choosing and using our App");
			 break;
			 default:
				 System.out.println("Please check your input");
				 userMenu(mailid);
				 
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
			 try {
				userMenu(mailid);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
				 toAddAccountDetails(mailid);
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
		 bank_details.add(new BankDetailsPojo(mailid,acc_no,IFSC_code,bank_name,display_name,upi_id,balance,0));
		 System.out.println("Your Account is Added Successfully");
		 System.out.println("Do you want to continue yes-1/no-0");
		 int con=input.nextInt();
		 if(con==1)
		 {
			 try {
				userMenu(mailid);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		      SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		       String datestr= formatter.format(date);
		       transaction_log.add(new TransactionLogsPojo(mailid,acc_no,"Deposit",amount,datestr));
		       toAddBankAccount(mailid);
			 
			 
		 }
		 else
		 {
			 System.out.println("Please check your account number");
			 try {
				userMenu(mailid);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
public void toPay(String mailid) throws ParseException
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
				 try {
					userMenu(mailid);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
     SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
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
public void payViaBankAccount(String mailid) throws ParseException
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
				 try {
					userMenu(mailid);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
     SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
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

public void toInvite(String mailid)
{
	System.out.println("**************************************************************");
	System.out.println("1.Show invitecode");
	System.out.println("2.view Rewards amount");
	System.out.println("3.Go Back");
	System.out.println("Enter your choice");
	int choice=input.nextInt();
	switch(choice)
	{
	case 1:
		toShowInviteCode(mailid);
		break;
	case 2:
		toViewRewardAmount(mailid);
		break;
	case 3:
		try {
			userMenu(mailid);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		default:
			System.out.println("Please Check your input");
			toInvite(mailid);
	}
	
}
public void toShowInviteCode(String mailid)
{
	System.out.println("********************************************************************");
	for(int i=0;i<user_registration.size();i++)
	{
		if(user_registration.get(i).getMail_id().equals(mailid))
		{
			System.out.println("Your Referrel code is"+user_registration.get(i).getInvite_code());
		}
		
 }
	try {
		userMenu(mailid);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void toViewRewardAmount(String mailid)
{
	System.out.println("********************************************************************");
	 int reward_amt=0;
	 for(int i=0;i<bank_details.size();i++)
	 {
		 if(bank_details.get(i).getMailid().equals(mailid))
		 {
			 reward_amt=reward_amt+bank_details.get(i).getReward();
		 }
		 
		 }
	 System.out.println("Your total Reward amount is"+reward_amt);
	 try {
		userMenu(mailid);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
 }
public void toViewTransactionHistory(String mailid) throws ParseException
{  

int choice;

	System.out.println("********************************************************************");
	System.out.println("1.Toview last 7days transaction");
	System.out.println("2.Toview last 14days transaction");
	System.out.println("3.Toview last 30days transaction");
	System.out.println("4.Toview All transaction");
	System.out.println("5.Go Back");
	System.out.println("Enter your choice");
	choice=input.nextInt();
	switch(choice)
	{
	case 1:
		toViewdaysTransaction(mailid);
		break;
	case 2:
		toViewdaysTransaction(mailid);
		break;
	case 3:
		toViewdaysTransaction(mailid);
		break;
	case 4:
		toViewAllTransaction(mailid);
		break;
	case 5:
		userMenu(mailid);
		
	}
}
public void toViewAllTransaction(String mailid)
{
	String acc_no;
	System.out.println("Enter Account number to check transaction History");
	acc_no=input.next();
	System.out.println("--------------------------------------------------------------------");
	System.out.println("MAIL_ID     ACC_NUM     AMOUNT      DATE      DESCEIPTION");
	System.out.println("--------------------------------------------------------------------");
	for(int i=0;i<transaction_log.size();i++)
	 {
		 if(transaction_log.get(i).getAcc_no().equals(acc_no)&&transaction_log.get(i).getMailid().equals(mailid))
		 {
			 System.out.println(transaction_log.get(i).getMailid()+"     "+transaction_log.get(i).getAcc_no()+"    "+transaction_log.get(i).getAmt()+"      "+transaction_log.get(i).getDate()+"     "+transaction_log.get(i).getTransaction_type());
		 }
		 
		 }
	System.out.println("--------------------------------------------------------------------");
	
	try {
		userMenu(mailid);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void toViewdaysTransaction(String mailid) throws ParseException
{
	String acc_no;
	long day;
	System.out.println("Enter Account number to check transaction History");
	String date=null;
	acc_no=input.next();
	 Date curdate = new Date();
     SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
      String curr_date= formatter.format(curdate);
      Date current_date=formatter.parse(curr_date);
      Date trans_date=null;
      long diff;
      long days = 0;
      System.out.println("Enter the number of days");
      day=input.nextInt();
	for(int i=0;i<transaction_log.size();i++)
	 {
		 if(transaction_log.get(i).getAcc_no().equals(acc_no)&&transaction_log.get(i).getMailid().equals(mailid))
		 {
			 date=transaction_log.get(i).getDate();
			 trans_date=formatter.parse(date);
			 diff=current_date.getTime()-trans_date.getTime();
			 days=(diff/(60 * 60 * 1000))/24;
		 }
	if(days<=day)
	{
		System.out.println("--------------------------------------------------------------------");
		System.out.println("MAIL_ID     ACC_NUM     AMOUNT      DATE      DESCRIPTION");
		System.out.println("--------------------------------------------------------------------");
		 System.out.println(transaction_log.get(i).getMailid()+"     "+transaction_log.get(i).getAcc_no()+"    "+transaction_log.get(i).getAmt()+"      "+transaction_log.get(i).getDate()+"     "+transaction_log.get(i).getTransaction_type());
			
		
	}
}

}

}
      
	

	



