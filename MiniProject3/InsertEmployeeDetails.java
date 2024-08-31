package MiniProject3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertEmployeeDetails {

	public static Connection con = null;

	public static void insertIntoEmployee() {
		Scanner sc = new Scanner(System.in);

		try (sc) {
			con = DBConnection1.getMyConnection();
			PreparedStatement ptmt1 = con.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?)");
			char choice;
			do {
				System.out.println("EMPLOYEE REGISTRATION PROCESS.");
				System.out.println("------------------------------");
				System.out.println(
						"Register below details:\n-------------------------------\n 1.EmployeeId \n 2.EmployeeName \n 3.EmployeeAge \n 4.EmployeeSalary.\n------------------------------");

				System.out.println("enter eId:");
				int eid = sc.nextInt();
				ptmt1.setInt(1, eid);
				System.out.println("enter eName:");
				String ename = sc.next();
				ptmt1.setString(2, ename);
				System.out.println("enter eAge:");
				int eage = sc.nextInt();
				ptmt1.setInt(3, eage);
				System.out.println("enter eSalary:");
				double esal = sc.nextDouble();
				ptmt1.setDouble(4, esal);

				int executeUpdate = ptmt1.executeUpdate();
				if (executeUpdate > 0) {
					System.out.println(executeUpdate + " row inserted successfully.");
				} else {
					System.out.println("row not inserted successfully.");
				}
				System.out.println(
						"Do you want to insert more employee.\n enter \n 1.y for yes \n 2.n for no \n-----------------------------------------------");
				choice = sc.next().charAt(0);
				if (choice != 'Y' || choice != 'y') {
					System.out.println("thank you for employee registration.\n--------------------------------------");
				}
				sc.nextLine();

			} while (choice == 'y' || choice == 'Y');

		} catch (Exception e) {
			System.out.println("invalid registration.");
			e.printStackTrace();
		}
	}
}
