package MiniProject3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RetrieveEmployeeDetails {
	public static Connection con = null;

	public static void getEmployeeDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("EMPLOYEE DATA RETRIEVING PROCESS.");
		System.out.println("---------------------------------");
		List<EmployeeDetails> empList1 = new ArrayList<EmployeeDetails>();

		try {
			con = DBConnection1.getMyConnection();
			Statement stmt1 = con.createStatement();
			ResultSet rs1 = stmt1.executeQuery("SELECT * FROM EMPLOYEE");

			ResultSetMetaData rsmd1 = rs1.getMetaData();

			while (rs1.next()) {
				EmployeeDetails ed1;
				ed1 = new EmployeeDetails();
				ed1.seteId(rs1.getInt(1));
				ed1.seteName(rs1.getString(2));
				ed1.seteAge(rs1.getInt(3));
				ed1.seteSal(rs1.getDouble(4));

				empList1.add(ed1);

			}
			System.out.println(
					"Do you want to retrieve all customers or specific\n enter \n 1.All Customers \n 2.Specific Customers \n 3.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("You have selected all cutomers data.");
				System.out.println("------------------------------------");
				for (int i = 1; i <= rsmd1.getColumnCount(); i++) {
					System.out.print(rsmd1.getColumnName(i) + "\t");
				}
				System.out.println("\n------------------------------------------");

				empList1.forEach(System.out::println);
				System.out.println("-------------------------------------------------------------");
				break;
			case 2:
				System.out.println("You have selected specific customers data.");
				System.out.println("------------------------------------------");
				for (int i = 1; i <= rsmd1.getColumnCount(); i++) {
					System.out.print(rsmd1.getColumnName(i) + "\t");
				}
				System.out.println("\n------------------------------------------");

				empList1.stream().filter((e -> e.geteAge() > 25)).forEach(System.out::println);
				System.out.println("-------------------------------------------------------------");
				break;
			case 3:
				System.out.println("Exiting Application\n----------------\n thank you :)\n-------------");
				System.exit(0);
				sc.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
// below line will print the column data without adjusting to string.
// empList1.forEach(x->System.out.println(x.geteId()+" "+x.geteName()+"
// "+x.geteAge()+" "+x.geteSal()));
// empList1.stream().filter(x->x.geteName().equalsIgnoreCase("harsh")).forEach(System.out::println);
