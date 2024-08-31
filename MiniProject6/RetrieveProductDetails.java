package MiniProject6;

import java.sql.Connection;
import java.util.Scanner;

public class RetrieveProductDetails {
   public static Connection con=null;
    
   Scanner sc=new Scanner(System.in);
    public static void retrieveForward()
	{
    	Scanner sc=new Scanner(System.in);
		try(sc){
			con=ConnectToDB.connectDB();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void retrieveBackward()
	{
		Scanner sc=new Scanner(System.in);
		try(sc){
			con=ConnectToDB.connectDB();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public static void retrieve3rdFromTop()
	{
		Scanner sc=new Scanner(System.in);
		try(sc){
			con=ConnectToDB.connectDB();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public static void retrieve3rdFromBottom()
	{
		Scanner sc=new Scanner(System.in);
		try(sc){
			con=ConnectToDB.connectDB();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	
}
