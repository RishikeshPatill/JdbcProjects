package MiniProject3;

import java.sql.Statement;

import java.sql.Connection;

public class EmployeeTableQueries {
	public static Connection con = null;
	public static Statement stmt = null;

	public static void getEmployeeQuery(String query) {
		try {
			con = DBConnection1.getMyConnection();
			stmt = con.createStatement();
			boolean execute = stmt.execute(query);
			if (execute == false) {
				System.out.println("query executed successfully.");
				System.out.println("----------------------------");
			} else {
				System.out.println("query not executed.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
