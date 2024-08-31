package MiniProject5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class EmpInsertion {
	public static Connection con = null;
	public static void insertEmp()
	{
		
		System.out.println("EMPLOYEE REGISTRATION PAGE:");
		System.out.println("----------------------------");
		Scanner sc=new Scanner(System.in);
		try (sc){
		con = DBConnection1.getMyConnection();
		char choice;
		do {
			System.out.println("enter employee details\n-----------------------------");
		PreparedStatement ptmt1=con.prepareStatement("insert into emp_info values (?,?,?,?,?)");
		
		System.out.println("enter EMP id:");
		int id =sc.nextInt();
		ptmt1.setInt(1, id);
		System.out.println("enter  EMP name:");
		String name=sc.next();
		ptmt1.setString(2, name);
		System.out.println("enter  EMP email:");
		String email=sc.next();
		ptmt1.setString(3, email);
		System.out.println("enter EMP  phone:");
		 long phone=Long.parseLong(sc.next());
		ptmt1.setLong(4, phone);
		System.out.println("Enter emp sal:");
		long sal=Long.parseLong(sc.next());
		ptmt1.setLong(5, sal);
		
		ptmt1.executeUpdate();
		System.out.println("do you waant to continue insert:");
		choice=sc.next().charAt(0);
		
		}while(choice=='y'||choice=='Y');
		
//		Statement stmt1=con.createStatement();
//		
//		ResultSet rs1=stmt1.executeQuery("select * from emp_info");
//		ResultSetMetaData  rsmd1=rs1.getMetaData();
//		
//		for(int i=1;i<=rsmd1.getColumnCount();i++)
//		{
//			System.out.println(rsmd1.getColumnCount()+ "column count");
//			System.out.println(rsmd1.getColumnName(i)+"\t");
//			
//			System.out.println(rsmd1.getColumnTypeName(i)+"\t");
//			System.out.println("-------------------------------");
//		}
//		System.out.println("-------------------------------");
//		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
