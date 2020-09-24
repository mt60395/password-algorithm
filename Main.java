import static java.lang.System.*;
import java.util.Scanner;

class Main {
	public static String getPassword(String name, String website, String secret, String month, int year) {
		String password = "";
		// name
		String[] names = name.split(" ");
		String first = names[0].toLowerCase();
		String surname = names[1].toLowerCase();
		password += surname.substring(surname.length()-2) + first.substring(first.length()-2); // last 2 of last, last 2 of first
		password = password.substring(0, 1).toUpperCase() + password.substring(1); // capitalize the first

		// website
		website = website.charAt(1) + Character.toString(website.charAt(0)); // prevent the second char from adding as an integer
		website = website.substring(0, 1).toUpperCase() + website.substring(1).toLowerCase(); // capitalize the first
		password += website;

		// secret / special code
		password += secret;

		// month
		String vowels = "aeiouyAEIOUY";
		for (char ch: month.toCharArray()) {
			if (vowels.indexOf(ch) >= 0) {
				password += Character.toString(ch).toLowerCase(); // October, first letter is a capital O
			}
		}

		// year
		String yearstr = String.valueOf(year);
		password += yearstr.charAt(0);
		password += yearstr.charAt(yearstr.length() - ((year > 2000) ? 1 : 2));
		// first and last if after 2000. first and third if before 2000
		return password;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		out.print("First and Last Name: ");
		String name = input.nextLine();
		out.print("Website: ");
		String website = input.nextLine();
		out.print("Special Code: ");
		String secret = input.nextLine();
		out.print("Birth Month: ");
		String month = input.nextLine();
		out.print("Birth Year: ");
		int year = input.nextInt();
		out.printf("\nPassword: %s\n", getPassword(name, website, secret, month.toLowerCase(), year));
	}
}