package MiniProject4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class AccountEnquiry {

	public static Connection con = null;
	private static long accountBalance;

	public static void getAccountBalance() {
		Scanner sc = new Scanner(System.in);
		try (sc) {
			con = DBConnection1.getMyConnection();
			PreparedStatement ptmt1 = con.prepareStatement("SELECT ACCOUNT_NUMBER,BALANCE FROM ACCOUNTS WHERE ACCOUNT_NUMBER=?");
			
			System.out.println("Enter Account Number:");
			long accountNumber = Long.parseLong(sc.next());
			ptmt1.setLong(1, accountNumber);
			ResultSet rs1=ptmt1.executeQuery();
            while(rs1.next())
            {
            	long accountNum=rs1.getLong(1);
            	long balance=rs1.getLong(2);
            
            	System.out.println(balance+" Rs is Available Balance for Account "+accountNum);

            }
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void getAccountDetails() {
		long accountNumber=0;
		Scanner sc = new Scanner(System.in);
		try (sc) {
			con = DBConnection1.getMyConnection();
			PreparedStatement ptmt1=con.prepareStatement("SELECT * FROM ACCOUNTS WHERE ACCOUNT_NUMBER=?");
			System.out.println("Enter Account Number:");
			accountNumber=Long.parseLong(sc.next());
			ptmt1.setLong(1, accountNumber);
			ResultSet rs1=ptmt1.executeQuery();
			if(rs1.next()) {
				ResultSetMetaData rsmd1=rs1.getMetaData();
				for(int i=1;i<rsmd1.getColumnCount();i++)
				{
					System.out.print(rsmd1.getColumnName(i)+"\t");
				}
				System.out.println("\n--------------------------------------------");
				//we added this line to move the cursor before first record again.
				rs1=ptmt1.executeQuery();
				while(rs1.next())
				{
					System.out.print(rs1.getLong(1)+"\t");
					System.out.print(rs1.getLong(2)+"\t");
					System.out.print(rs1.getString(3)+"\t");
					System.out.println();
				}
			}
			else {
				System.out.println("invalid account number");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
