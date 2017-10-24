package caesar;

import java.util.Scanner;

public class runner {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		
		CaesarCipher myCipher = new CaesarCipher();
		System.out.println("Please enter the plain text to encode:");
		String plainText = kbd.nextLine().toLowerCase();
		System.out.println("Please enter the key: ");
		int key = kbd.nextInt();
		System.out.println("Your key is " + key);
		String codedText = myCipher.encode(plainText, key);
		System.out.println("Your encoded message is: " + codedText);

	}

}
