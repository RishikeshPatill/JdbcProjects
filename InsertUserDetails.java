package MiniProject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertUserDetails {
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username = "RISHIKESH";
	private static final String password = "RISHI";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established Successfully!!!");
			System.out.println("-----------------------------------------");

			// INSERT RECORD INTO USERDETAILS TABLE DYNAMICALLY.
			PreparedStatement ptmt = con.prepareStatement("INSERT INTO USERDETAILS VALUES(?,?,?,?,?,?)");
			char choice;
			do {
				System.out.println("insert the value of user:");
				System.out.println("------------------------");

				System.out.println("enter username:");
				String userName = sc.nextLine();
				ptmt.setString(1, userName);

				System.out.println("enter password:");
				String passWord = sc.nextLine();
				ptmt.setString(2, passWord);

				System.out.println("enter ufname:");
				String ufname = sc.nextLine();
				ptmt.setString(3, ufname);

				System.out.println("enter ulname");
				String ulname = sc.nextLine();
				ptmt.setString(4, ulname);

				System.out.println("enter mailid:");
				String mailid = sc.nextLine();
				ptmt.setString(5, mailid);

				System.out.println("enter phone number:");
				long phoneNumber = sc.nextLong();
				ptmt.setLong(6, phoneNumber);
				
				

				System.out.println(ptmt.executeUpdate()+" row inserted successfully!!!");
				System.out.println("user inserted successfully.");
				System.out.println("--------------------------------");
				

				System.out.println("do you want to continue to insert values.\n 1.y for yes. \n 2.n for no.");
				choice = sc.next().charAt(0);
				sc.nextLine();

			} while (choice == 'y' || choice == 'Y');

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
