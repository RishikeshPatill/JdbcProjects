package MiniProject6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ProductInsertion {
  public static Connection con=null;
  
	public static void insertProductDetails()
	{
		Scanner sc=new Scanner(System.in);
		try(sc){
			con=ConnectToDB.connectDB();
			char choice;
			do {
			PreparedStatement ptmt1=con.prepareStatement("INSERT INTO PRODUCT VALUES(?,?,?,?)");
			System.out.println("enter product id:");
			int id=sc.nextInt();
			ptmt1.setInt(1, id);
			System.out.println("enter product name:");
			String name=sc.next();
			ptmt1.setString(2, name);
			System.out.println("enter product price:");
			double price=sc.nextDouble();
			ptmt1.setDouble(3,price);
			System.out.println("enter product quantity:");
			int qty=sc.nextInt();
			ptmt1.setInt(4, qty);
			
			int executeUpdate = ptmt1.executeUpdate();
		    System.out.println(executeUpdate+" row inserted successfully");
		    System.out.println("----------------------------------------");
		    System.out.println("do you want to iunsert more.\n enter 1.y\n2.n");
		    System.out.println("----------------------------------------");

		    System.out.println("enter your choice:");
		    choice=sc.next().charAt(0);
		    System.out.println("----------------------------------------");

			}while(choice=='y'||choice=='Y');
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
