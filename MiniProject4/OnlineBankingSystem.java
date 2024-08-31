package MiniProject4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class OnlineBankingSystem {
	public static Connection con = null;
	public static String accountName = null;
	public static String pin = null;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try (sc) {
			con = DBConnection1.getMyConnection();
			PreparedStatement ptmt1 = con.prepareStatement("SELECT ACCOUNT_NAME,PIN FROM ACCOUNTS WHERE ACCOUNT_NAME=? ");
			// LOGIN PAGE
			System.out.println("Enter Account Name:");
			accountName = sc.next();
			ptmt1.setString(1, accountName);
			ResultSet rs1=ptmt1.executeQuery();
			if(rs1.next())
			{
				/*
				 * System.out.println(accountName); System.out.println(rs1.getString(1));
				 */
				if(accountName.equals(rs1.getString(1)))
				{
					System.out.println("Enter your pin "+accountName+":");
					pin = sc.next();
					rs1=ptmt1.executeQuery();
					if(rs1.next())
					{
						if(pin.equals(rs1.getString(2))) {
						// MAIN PROCESS
						System.out.println("WELCOME TO  ONLINE BANKING APPLICATION.");
						System.out.println("---------------------------------------");

						//SELECT * FROM TABLE_NAME WHERE ACCOUNT_NAME=?
						
						System.out.println(
								" BANKING OPTIONS:\n 1.Transaction \n 2.Account Enquiry \n 3.Show All Account Details \n 4.Exit Application \n---------------------------");
						System.out.println("Enter Your Option:");
						int option = sc.nextInt();
						System.out.println("---------------------------------------------");

						switch (option) {
						case 1:
							System.out.println("you have selected transaction:");
							System.out.println("------------------------------");
							System.out.println(
									"Enter\n1.WithDraw\n2.Deposit\n3.Transact Money\n4.Exit Application\n---------------------");
							System.out.println("Enter your option:");
							int option1 = sc.nextInt();
							switch (option1) {
							case 1:
								System.out.println("you have selected withdraw process:");
								System.out.println("-----------------------------------");
								AccountTransaction.withdrawProcess();
								break;
							case 2:
								System.out.println("you have selected deposit process:");
								System.out.println("----------------------------------");

								AccountTransaction.depositProcess();
								break;
							case 3:
								System.out.println("you have selected transaction process:");
								System.out.println("--------------------------------------");
								AccountTransaction.transactionProcess();
								break;
							case 4:
								System.out.println("EXITING APPLICATION\nthank you:)");
								System.out.println("--------------------------------");

								System.exit(0);
								break;
							default:
								System.out.println("invalid option.");
								System.out.println("---------------");
							}
							break;

						case 2:
							System.out.println("you have selected account inquiry:");
							System.out.println("----------------------------------");
							System.out.println("Enter\n1.Check Balance\n2.Account Details\n3.Exit Application\n-----------------");
							System.out.println("enter your option:");
							int option2 = sc.nextInt();
							System.out.println("------------------");
							switch (option2) {
							case 1:
								System.out.println("you have selected check balance.");
								System.out.println("--------------------------------");
								AccountEnquiry.getAccountBalance();
								break;
							case 2:
								System.out.println("you have selected account details:");
								System.out.println("----------------------------------");
								AccountEnquiry.getAccountDetails();
								break;
							case 3:
								System.out.println("EXITING APPLICATION\nthank you:)");
								System.out.println("------------------------------- ");
								System.exit(0);
								break;
							default:
								System.out.println("invalid option.");
								System.out.println("---------------");

							}
							break;

						case 3:
							System.out.println("you have selected show all account details.");
							System.out.println("-------------------------------------------");
							BankAdmin.showAllCustomers();
							break;

						case 4:
							System.out.println("EXITING APPLICATION\nthank you:)");
							System.out.println("--------------------------------");
							System.exit(0);
							break;

						default:
							System.out.println("invalid option.");
							System.out.println("---------------");

						}//OUTER SWITCH
						}//PIN

					else
					{
						System.out.println("incorrect pin");
					}
				}//RSIF
			    else 
				{
					System.out.println("inavalid account name.");
				}
								
			}//NAME
			else {
				System.out.println("invalid account name or pin");
			}

		} 
		}catch (Exception e) {
			e.printStackTrace();
		}

//		// MAIN PROCESS
//		System.out.println("WELCOME TO  ONLINE BANKING APPLICATION.");
//		System.out.println("---------------------------------------");
//
//		System.out.println(
//				" BANKING OPTIONS:\n 1.Transaction \n 2.Account Enquiry \n 3.Show All Account Details \n 4.Exit Application \n---------------------------");
//		System.out.println("Enter Your Option:");
//		int option = sc.nextInt();
//
//		switch (option) {
//		case 1:
//			System.out.println("you have selected transaction:");
//			System.out.println("------------------------------");
//			System.out.println(
//					"Enter\n1.WithDraw\n2.Deposit\n3.Transact Money\n4.Exit Application\n---------------------");
//			System.out.println("Enter your option:");
//			int option1 = sc.nextInt();
//			switch (option1) {
//			case 1:
//				System.out.println("you have selected withdraw process:");
//				AccountTransaction.withdrawProcess();
//				break;
//			case 2:
//				System.out.println("you have selected deposit process:");
//				AccountTransaction.depositProcess();
//				break;
//			case 3:
//				System.out.println("you have selected transaction process:");
//				AccountTransaction.transactionProcess();
//				break;
//			case 4:
//				System.out.println("EXITING APPLICATION\nthank you:)");
//				System.exit(0);
//				break;
//			default:
//				System.out.println("invalid option.");
//			}
//			break;
//
//		case 2:
//			System.out.println("you have selected account inquiry:");
//			System.out.println("----------------------------------");
//			System.out.println("Enter\n1.Check Balance\n2.Account Details\n3.Exit Application\n-----------------");
//			System.out.println("enter your option:");
//			int option2 = sc.nextInt();
//			switch (option2) {
//			case 1:
//				System.out.println("you have selected check balance.");
//				AccountEnquiry.getAccountBalance();
//				break;
//			case 2:
//				System.out.println("you have selected account details:");
//				AccountEnquiry.getAccountDetails();
//				break;
//			case 3:
//				System.out.println("EXITING APPLICATION\nthank you:)");
//				System.exit(0);
//				break;
//			default:
//				System.out.println("invalid option.");
//
//			}
//			break;
//
//		case 3:
//			System.out.println("you have selected show all account details.");
//			break;
//
//		case 4:
//			System.out.println("EXITING APPLICATION\nthank you:)");
//			System.exit(0);
//			break;
//
//		default:
//			System.out.println("invalid option.");
//
//		}
	}
}
