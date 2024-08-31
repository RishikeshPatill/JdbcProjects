package MiniProject4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class BankAdmin {
	public static Connection con=null;
	
	
public static void showAllCustomers()
{   
	
	
	Scanner sc=new Scanner(System.in);
	try(sc)
	{
		
		con=DBConnection1.getMyConnection();
	    PreparedStatement ptmt1=con.prepareStatement("SELECT ACCOUNT_NAME FROM ACCOUNTS WHERE ACCOUNT_NAME=?");
	    System.out.println("Enter Account Name:");
	    String accountName=sc.next();
	    ptmt1.setString(1, accountName);
	    ResultSet rs1=ptmt1.executeQuery();
	    if(accountName.equals("ADMIN"))
	    {
	    	
	    	//SELECT NAME,PIN FORM TABLE WHERE NAME=?
	    	//RS = rs.getStrin().
	    	//INPUT PIN
			PreparedStatement ptmt2 = con.prepareStatement("SELECT PIN FROM ACCOUNTS WHERE ACCOUNT_NAME=?");
			ptmt2.setString(1, accountName);
			ResultSet rs2=ptmt2.executeQuery();
			if(rs2.next())
			{
				String pin1=rs2.getString(1);
				System.out.println("Enter your pin:");
				String pin = sc.next();
				System.out.println("--------------------------------------------------");				
				if(pin1.equals(pin))
				{
					System.out.println("WELCOME ADMIN.");
					PreparedStatement ptmt3=con.prepareStatement("SELECT * FROM ACCOUNTS");
			    	ResultSet rs3=ptmt3.executeQuery();
			    	ResultSetMetaData rsmd1=rs3.getMetaData();
			    	for(int i=1;i<rsmd1.getColumnCount();i++)
			    	{
			    		System.out.print(rsmd1.getColumnName(i)+"\t");
			    	}
			    	System.out.println("\n-----------------------------------------");
			    	while(rs3.next())
			    	{
			    		System.out.print(rs3.getLong(1)+"\t");
			    		System.out.print(rs3.getLong(2)+"\t");
			    		System.out.print(rs3.getString(3)+"\t");
			    		System.out.println();
			    		
			    	}//WHILE
					
				}//PIN

//	    	System.out.println("Enter your pin:");
//	    	String pin=sc.next();
//	    	
	    	
	    }//RS2 IF
	    else
	    {
	    	System.out.println("sorry you can not access this feature.\n you are not the authorized admin\n------------------------------------------");
	    }
				
	    }//ACCOUNT NAME
	    
	}//TRY
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
