package lab7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Lab7 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		nameValidator(scnr);
		emailValidator(scnr);
		phoneNumberValidator(scnr);
		dateValidator(scnr);
		htmlValidator(scnr);
		System.out.println("Thanks for playing!");
		scnr.close();
	}	
		public static String nameValidator(Scanner scnr) {
			boolean valid = false;
			System.out.println("Please enter a valid name: ");
			String input;
			do {
				input = scnr.nextLine();
				// Valid Java identifier:      ([A-Z][a-z]+){1,30}\s*([A-Z][a-z]+){0,30}
				valid = input.matches("([A-Z][a-z]+){1,30}\\s*([A-Z][a-z]+){0,30}");
				
				System.out.println(valid ? "You entered a valid name!" : "You entered an invalid name :(");
			} while (!valid);
			return input;
		}
		
		public static String emailValidator(Scanner scnr) {
			boolean valid = false;
			System.out.println("Please enter a valid email address: ");
			String input;
			do {
				input = scnr.nextLine();
				// Valid Java identifier:      ([A-Za-z\d]){5,30}@([A-Za-z\d]){5,10}\.([A-Za-z]){2,3}
				valid = input.matches("([A-Za-z\\d]){5,30}@([A-Za-z\\d]){5,10}\\.([A-Za-z]){2,3}");
				
				System.out.println(valid ? "Email is valid!" : "Email is invalid! :(");
			} while (!valid);
			return input;
		}
		
		public static String phoneNumberValidator(Scanner scnr) {
			boolean valid = false;
			System.out.println("Please enter a valid telephone number using format xxx-xxx-xxxx: ");
			String input;
			do {
				input = scnr.nextLine();
				// Valid Java identifier:      \d{3}-\d{3}-\d{4}
				valid = input.matches("\\d{3}-\\d{3}-\\d{4}");
				
				System.out.println(valid ? "Phone number is valid." : "Phone number is invalid! :(");
			} while (!valid);
			return input;
		}

		public static Date dateValidator(Scanner scnr) {
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			format.setLenient(false); // <-- date format must match
			boolean valid = false;
			Date date = null;
			System.out.println("Please enter a date using format mm/dd/yyyy.");
			String input;
			do {
				// Get the raw string
				input = scnr.nextLine();
				// Step 2: convert it to a date
				try {
					// format.parse throws a ParseException, which is a checked exception and MUST be caught.
					date = format.parse(input);
					// If exception doesn't occur, it's valid.
					valid = input.matches("[01]\\d\\/[0123]\\d\\/\\d{4}");
				} catch (ParseException ex) {
					// If exception occurs, it's invalid.
					valid = false;
					System.out.println("Enter a valid date in format mm/dd/yyyy.");
				}
				System.out.println(valid ? "Date entered is valid." : "Date entered is invalid! :(");
			} while (!valid);
			return date;
		}
		
		public static String htmlValidator(Scanner scnr) {
			boolean valid = false;
			System.out.println("Please enter valid html elements: ");
			String input;
			do {
				input = scnr.nextLine();
				// Valid Java identifier:      <[A-z]\d?>\s.*<\/[A-z]\d?>  looking for <[definitely a letter][possible number]> [space] [possible text] </[definitely a letter][possible number]>
				valid = input.matches("<[A-z]\\d?>\\s.*<\\/[A-z]\\d?>");
				
				System.out.println(valid ? "You entered valid html elements!" : "You entered invalid html elements. :(");
			} while (!valid);
			return input;
		}
}
