package MiniProject4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AccountTransaction {

	public static Connection con = null;

	public static void transactionProcess() {

		Scanner sc = new Scanner(System.in);

		try (sc) {
			con = DBConnection1.getMyConnection();
			// SENDER INFO
			long senderBalance = 0;
			long senderAccount = 0;
			PreparedStatement ptmt1 = con.prepareStatement("SELECT BALANCE  FROM ACCOUNTS WHERE ACCOUNT_NUMBER=?");
			System.out.println("Enter the sender account number:");
			senderAccount = Long.parseLong(sc.next());
			ptmt1.setLong(1, senderAccount);
			ResultSet rs1 = ptmt1.executeQuery();
			if (rs1.next() == true) {
				senderBalance = rs1.getLong(1);

				// RECIEVER INFO
				long recieverBalance = 0;
				long recieverAccount = 0;
				PreparedStatement ptmt2 = con.prepareStatement("SELECT BALANCE FROM ACCOUNTS WHERE ACCOUNT_NUMBER=?");
				System.out.println("Enter Reciever Account:");
				recieverAccount = Long.parseLong(sc.next());
				ptmt2.setLong(1, recieverAccount);
				ResultSet rs2 = ptmt2.executeQuery();
				if (senderAccount != recieverAccount) {
					if (rs2.next() == true) {
						recieverBalance = rs2.getLong(1);

						// TRANSACTION PROCESS,DEBIT,CREDIT.
						System.out.println("Enter the amount you want to transact:");
						long transferAmount = Long.parseLong(sc.next());
						if (transferAmount > senderBalance) {
							System.out.println("Transaction failed!!!\n insufficient balance.");
						} else {

							// CREDIT PROCESS
							PreparedStatement ptmt3 = con
									.prepareStatement("UPDATE ACCOUNTS SET BALANCE=? WHERE ACCOUNT_NUMBER=?");
							senderBalance = senderBalance - transferAmount;
							ptmt3.setLong(1, senderBalance);
							ptmt3.setLong(2, senderAccount);

							// DEBIT PROCESS
							PreparedStatement ptmt4 = con
									.prepareStatement("UPDATE ACCOUNTS SET BALANCE=? WHERE ACCOUNT_NUMBER=?");
							recieverBalance = recieverBalance + transferAmount;
							ptmt4.setLong(1, recieverBalance);
							ptmt4.setLong(2, recieverAccount);

							if (ptmt3.executeUpdate() != 0) {
								System.out
										.println("------------------------------------------------------------------");
								System.out.println("transaction in process...");
								System.out.println(
										transferAmount + " Rs credited from " + senderAccount + " account number.");
								System.out
										.println("------------------------------------------------------------------");
								if (ptmt4.executeUpdate() != 0) {
									System.out.println("transaction successfull");
									System.out.println(
											transferAmount + " Rs debited to " + recieverAccount + " account number.");
									System.out.println(
											"----------------------------------------------------------------");
								}

							} else {
								System.out.println("Transaction failed !!!");
							}

						}

					} else {
						System.out.println("invalid reciever account number.");
					}
				} else {
					System.out.println("both account number cant be same.");
				}
			} else {
				System.out.println("invalid sender account number");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void withdrawProcess() {
		long withdrawBalance = 0;
		long userAvailableBalance = 0;
		long userAccount = 0;
		String pin = null;
		Scanner sc = new Scanner(System.in);
		try (sc) {
			con = DBConnection1.getMyConnection();
			PreparedStatement ptmt1 = con.prepareStatement("SELECT BALANCE  FROM ACCOUNTS WHERE ACCOUNT_NUMBER=?");
			System.out.println("Enter your account number:");
			userAccount = Long.parseLong(sc.next());
			ptmt1.setLong(1, userAccount);
			ResultSet rs1 = ptmt1.executeQuery();
			//ACCOUNT CHECK,WITHDRAW PROCESS,PIN CHECK.
			if (rs1.next()) {
				userAvailableBalance = rs1.getLong(1);
				System.out.println("your total available balance is " + userAvailableBalance);
				System.out.println("--------------------------------------------------");
				System.out.println("Enter the amount you want to withdraw:");
				withdrawBalance = Long.parseLong(sc.next());
				System.out.println("--------------------------------------------------");
				
				//INPUT PIN
				PreparedStatement ptmt2 = con.prepareStatement("SELECT PIN FROM ACCOUNTS WHERE ACCOUNT_NUMBER=?");
				ptmt2.setLong(1, userAccount);
				ResultSet rs2=ptmt2.executeQuery();
				if(rs2.next())
				{
					String pin1=rs2.getString(1);
					System.out.println("Enter your pin:");
					pin = sc.next();
					System.out.println("--------------------------------------------------");				
					if(pin1.equals(pin))
					{
						System.out.println(withdrawBalance+" rs withdrawn from Account "+userAccount);
						System.out.println("---------------------------------------------------------------------");
						PreparedStatement ptmt3=con.prepareStatement("UPDATE ACCOUNTS SET BALANCE=? WHERE ACCOUNT_NUMBER=?");
						userAvailableBalance=userAvailableBalance-withdrawBalance;
						ptmt3.setLong(1, userAvailableBalance);
						ptmt3.setLong(2, userAccount);
						ptmt3.executeUpdate();
						System.out.println(userAvailableBalance+" is Available Balance in user Account "+userAccount);
						System.out.println("---------------------------------------------------------------------");
						
					}
					else {
						System.out.println("incorrect pin");
					}
				}
			

			} else {
				System.out.println("invalid user\n-----------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void depositProcess() {
		long depositBalance = 0;
		long depositAccount=0;
		long accountAvailableBalance=0;
		Scanner sc = new Scanner(System.in);
		try (sc) {
			con = DBConnection1.getMyConnection();
			PreparedStatement ptmt1 = con.prepareStatement("SELECT BALANCE  FROM ACCOUNTS WHERE ACCOUNT_NUMBER=?");
			System.out.println("Enter account number:");
			depositAccount = Long.parseLong(sc.next());
			ptmt1.setLong(1, depositAccount);
			ResultSet rs1 = ptmt1.executeQuery();
			if (rs1.next()) {
				accountAvailableBalance = rs1.getLong(1);
				System.out.println("your total available balance is " + accountAvailableBalance);
				System.out.println("--------------------------------------------------");
				System.out.println("Enter the amount you want to deposit:");
				depositBalance = Long.parseLong(sc.next());
				System.out.println("--------------------------------------------------");
				//deposit 
				PreparedStatement ptmt2=con.prepareStatement("UPDATE ACCOUNTS SET BALANCE=? WHERE ACCOUNT_NUMBER=?");
				accountAvailableBalance=accountAvailableBalance+depositBalance;
				ptmt2.setLong(1, accountAvailableBalance);
				ptmt2.setLong(2, depositAccount);
				int executeUpdate = ptmt2.executeUpdate();
				if(executeUpdate>0)
				{
					System.out.println(depositBalance+" Rs Amount deposited successfully.");
					System.out.println("-------------------------------------------------");
				}
				else {
					System.out.println("deposit failed.");
				}
				
			}
			else {
				System.out.println("invalid user\n-----------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
