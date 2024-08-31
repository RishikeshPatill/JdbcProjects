package MiniProject3;

import java.util.Scanner;

public class EmployeeMain {
	public static void main(String[] args) {
            
		//EmployeeTableQueries.getEmployeeQuery("CREATE TABLE EMPLOYEE(EID NUMBER(3),ENAME VARCHAR2(15),EAGE NUMBER(3),ESALARY NUMBER(8,2))");
		Scanner sc=new Scanner(System.in);
		System.out.println("WELWCOME TO EMPLOYEE SERVICES.");
		System.out.println("------------------------------");
		System.out.println("Do you wannt to insert or retrieve the employee data.\n enter \n 1.insert \n 2.retrieve \n 3.exit \n--------------------------------------------");
		int option=sc.nextInt();
		switch(option)
		{
		case 1:System.out.println("you have selected insertion process.");
		       System.out.println("------------------------------------");
		       InsertEmployeeDetails.insertIntoEmployee();
		       break;
		case 2:System.out.println("you have selected retrieving operation.");
		       System.out.println("---------------------------------------");
		       RetrieveEmployeeDetails.getEmployeeDetails();
		       break;
		case 3:System.out.println("EXITING APPLICATION.");
		       System.out.println("--------------------");
		       System.out.println("thank you :)");
		       System.exit(0);
		default:System.out.println("invalid option.\n please select correct option.\n thankYou:)\n---------------------------------");       
	       
		sc.close();
		        
		}
		
//		List<EmployeeDetails> li=RetrieveEmployeeDetails.retrive();
//		System.out.println("From Main "+li);
//		System.out.println(li.get(0).geteName());
//		
//		
//		System.out.println("Eid"+"\t"+"name"+"\t"+"age"+"\t"+"sal"+"\t");
//		System.out.println("-------------------------------------------------");
//		for(int i=0;i<li.size();i++) {
//			
//			System.out.print(li.get(i).geteId()+"\t");
//			System.out.print(li.get(i).geteName()+"\t");
//			System.out.print(li.get(i).geteAge()+"\t");
//			System.out.print(li.get(i).geteSal()+"\t");
//			System.out.println();
//			
//		}
//		
	}
}
