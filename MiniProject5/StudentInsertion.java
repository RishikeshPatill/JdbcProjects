package MiniProject5;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class StudentInsertion {
	public static Connection con = null;
	public static void insertStudent()
	{
		Scanner sc=new Scanner(System.in);
		try (sc){
		con = DBConnection1.getMyConnection();
		char choice;
		do {
		PreparedStatement ptmt1=con.prepareStatement("insert into student_info values (?,?,?,?)");
		
		System.out.println("enter id:");
		int id =sc.nextInt();
		ptmt1.setInt(1, id);
		System.out.println("enter name:");
		String name=sc.next();
		ptmt1.setString(2, name);
		System.out.println("enter add:");
		String add=sc.next();
		ptmt1.setString(3, add);
		System.out.println("enter date:");
		String date=sc.next();
		ptmt1.setString(4, date);
		
		ptmt1.executeUpdate();
		System.out.println("do you waant to continue insert:");
		choice=sc.next().charAt(0);
		
		}while(choice=='y'||choice=='Y');
		
		Statement stmt1=con.createStatement();
		
		ResultSet rs1=stmt1.executeQuery("select * from student_info");
		ResultSetMetaData  rsmd1=rs1.getMetaData();
		
		for(int i=1;i<=rsmd1.getColumnCount();i++)
		{
			System.out.println(rsmd1.getColumnCount()+ "column count");
			System.out.println(rsmd1.getColumnName(i)+"\t");
			
			System.out.println(rsmd1.getColumnTypeName(i)+"\t");
			System.out.println("-------------------------------");
		}
		System.out.println("-------------------------------");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
