package AdvJava;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PreparedStatementDemo {
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username = "RISHIKESH";
	private static final String password = "RISHI";

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established Successfully!!!");
			System.out.println("---------------------------------------------------");
			Scanner sc = new Scanner(System.in);

			// EXECUTE DYNAMIC QUERY USING COMMAND LINE ARGUMENT.
			PreparedStatement ptmt3 = con.prepareStatement("insert into student values(?,?,?,?)");
			System.out.println("enter sid:");
			ptmt3.setInt(1, Integer.parseInt(args[0]));
			System.out.println("enter sname:");
			ptmt3.setString(2, args[1]);
			System.out.println("enter sfees:");
			ptmt3.setDouble(3, Double.parseDouble(args[2]));
			System.out.println("enter sHobby");
			ptmt3.setString(4, args[3]);

			int executeUpdate3 = ptmt3.executeUpdate();
			System.out.println(executeUpdate3 + " rows updated");

			// EXECUTE NON STATIC OR DYNAMIC QUERY USING PREAPARED STATEMENT USING SCANNER.
//			PreparedStatement ptmt = con.prepareStatement("insert into emp values(?,?,?,?)");
//
//			char choice;
//			do {
//				System.out.println("Enter eid:");
//				int eid = sc.nextInt();
//				System.out.println("Enter ename:");
//				String ename = sc.next();
//				System.out.println("Enter esal:");
//				double esal = sc.nextDouble();
//				sc.nextLine();
//				System.out.println("Enter epost:");
//				String epost = sc.nextLine();
//
//				ptmt.setInt(1, eid);
//				ptmt.setString(2, ename);
//				ptmt.setDouble(3, esal);
//				ptmt.setString(4, epost);
//				ptmt.execute();
//
//				System.out.println("Do you want to continue 1.Y \n 2.N");
//				choice = sc.next().charAt(0);
//
//	        	} while (choice == 'Y' || choice == 'y');

			// DELETE ROW USING EXECUTE UPDATE.
			PreparedStatement ptmt2 = con.prepareStatement("delete from emp where esal in(377,988)");
			int executeUpdate = ptmt2.executeUpdate();
			System.out.println(executeUpdate + " rows deleted successfully");

			// PRINT DATA IN THE FORM OF TABLE USING STATEMENT AND RESULT SET.
			Statement stmt1 = con.createStatement();
			String query1 = "select * from emp";
			ResultSet rs = stmt1.executeQuery(query1);
			System.out.println("Eid     " + "Name     " + "Sal     " + "Post    ");
			System.out.println("------------------------------------------");
			while (rs.next()) {
				int eid = rs.getInt(1);
				String ename = rs.getString(2);
				double esal = rs.getDouble(3);
				String epost = rs.getString(4);

				System.out.print(eid + "\t");
				System.out.print(ename + "\t");
				System.out.print(esal + "\t");
				System.out.print(epost + "\t");
				System.out.println();
			}
			sc.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
