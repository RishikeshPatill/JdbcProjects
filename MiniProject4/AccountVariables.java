package MiniProject4;

public class AccountVariables {
	private static long senderAccountNumber;
	private static long recieverAccountNumber;
	private static long transferAmount;
	private static long accountBalance;

	public static long getSenderAccountNumber() {
		return senderAccountNumber;
	}

	public static void setSenderAccountNumber(long senderAccountNumber) {
		AccountVariables.senderAccountNumber = senderAccountNumber;
	}

	public static long getRecieverAccountNumber() {
		return recieverAccountNumber;
	}

	public static void setRecieverAccountNumber(long recieverAccountNumber) {
		AccountVariables.recieverAccountNumber = recieverAccountNumber;
	}

	public static long getTransferAmount() {
		return transferAmount;
	}

	public static void setTransferAmount(long transferAmount) {
		AccountVariables.transferAmount = transferAmount;
	}



	
}
