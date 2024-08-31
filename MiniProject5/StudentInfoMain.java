package MiniProject5;

import java.sql.Connection;

public class StudentInfoMain {
	public static Connection con = null;

	public static void main(String[] args) {

		try {
			con = DBConnection1.getMyConnection();
			//TableQueries.getEmployeeQuery("create table student_info(stuId number(5),stuName varchar2(20),stuAddress varchar2(20),dateOfAdmission date)");
			//StudentInsertion.insertStudent();
			//TableQueries.getEmployeeQuery("create table emp_info(empId number(4), empname varchar2(20),empMailId varchar2(10),empPhone number(10)) ");
			EmpInsertion.insertEmp();
			EmpUpdate.updateEmp();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
