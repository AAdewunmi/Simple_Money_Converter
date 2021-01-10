import java.util.Scanner;

/**
 * MoneyConverter Class to convert a sum of money to a different
 * currency. The amount of money to be converted, and the exchange rate, are
 * entered by the user.
 * @author Adrian Adewunmi
 * @version 10 January, 2021
 */

public class MoneyConverter {

	// Attributes
	private double amount;
	private double exchangeRate;
	private String currency;
	private String exchgCurrency;
	private char exit;
	Scanner scannerInt = new Scanner(System.in);
	Scanner scannerStr = new Scanner(System.in);

	/**
	 * Obtains currency and sum of money from the user
	 */

	public void obtainUserAmount() {

		System.out.println("Please enter currency name e.g Pound Sterling: ");
		currency = scannerStr.next();
		System.out.println("Please enter amount: ");
		amount = scannerInt.nextDouble();
	}

	/**
	 * Obtains exchange currency and exchange rate
	 */
	
	public void obtainExchangeRate() {

		System.out.println("Please enter exchange currency name e.g. Euro");
		exchgCurrency = scannerStr.next();
		System.out.println("Please enter exchange rate: ");
		exchangeRate = scannerInt.nextDouble();
	}

	/**
	 * Performs conversion of currency using supplied rate
	 * @param amountIn Sum of money from user
	 * @param exchangeRateIn Exchange rate from user
	 * @return exchangeAmount Returns the amount of exchanged money
	 */

	public double convertCurrency(double amountIn, double exchangeRateIn) {
		double exchangeAmount;
		exchangeAmount = amountIn * (1 + exchangeRateIn/100);
		return exchangeAmount;
	}

	/**
	 * After the result is displayed the user is asked
	 * if they wish to convert another sum of money.
	 * The program continues in this way until the user chooses to quit
	 */

	public void displayResults() {
		do {
			obtainUserAmount();
			obtainExchangeRate();
			double exchangedAmount;
			exchangedAmount = convertCurrency(amount, exchangeRate);
			System.out.println("\n" + amount + " " + currency + " is converted to " + exchangedAmount + " " + exchgCurrency);
			System.out.println("\nWould you like to make another conversion? (y/n)");
			exit = scannerStr.next().charAt(0);
		} while (exit == 'y' || exit == 'Y');
		System.out.println("Goodbye!!!");
	}
}
