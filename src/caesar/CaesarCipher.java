package caesar;

import javax.swing.JOptionPane;

public class CaesarCipher {
	
	private String alpha = "abcdefghijklmnopqrstuvwxyz 0123456789.:'";

	public String encode(String plainText, int key) {
		
		String secretText = "";
		int index, keyAdded;
		
		//System.out.println("test, alpha length = " + alpha.length());
		//System.out.println("test, first char is " + alpha.charAt(0));
		//System.out.println("test, last char is " + alpha.charAt(alpha.length()-1));
		
		//for (int i = 0; i < plainText.length(); i++) {
			//System.out.println(plainText.charAt(i));
		//}
		
		for (int i=0; i < plainText.length(); i++) {
			index = alpha.indexOf(plainText.charAt(i));
			//System.out.println(index);
			//Doug's Method
			keyAdded = (index + key) % alpha.length();
			if (plainText.charAt(i) == ' ') {
				keyAdded = index;
			}
			
			//System.out.println(keyAdded);
			//System.out.println(alpha.charAt(keyAdded));
			secretText = secretText + alpha.charAt(keyAdded);
		}
		//System.out.println("\nYour secert message is " + secretText);
		return secretText;
		
	}
	public String decode(String codedText, int key) {
		
		String decodedTextBeta = "";
		int index, keyAdded;
		
		for (int i=0; i < codedText.length(); i++) {
			index = alpha.indexOf(codedText.charAt(i));
			//System.out.println(index);
			//Doug's Method
			keyAdded = index - key;
			if (codedText.charAt(i) == ' ') {
				keyAdded = index;
			}
			else if (keyAdded < 0) {
				keyAdded = alpha.length()- (index + key);
			}
			
			//System.out.println(keyAdded);
			//System.out.println(alpha.charAt(keyAdded));
			decodedTextBeta = decodedTextBeta + alpha.charAt(keyAdded);
		}
		
		return decodedTextBeta;
	}
	//Each char that I read from plainText I find the index in alpha
	//for example, read A look up index for A get 0
	//then, add key to that index, so A index 0 becomes 0 + key
	//and 0+key becomes my coded char
	public int crack(String codedText) {
		String msg = "";
		int index, keyAdded;
		
		boolean StopLoop = false;
		
		int key = 1;
			while (StopLoop == false) {
				String testText= "";
				for (int i=0; i < codedText.length(); i++) {
					index = alpha.indexOf(codedText.charAt(i));
					keyAdded = index - key;
					if (keyAdded < 0) {
						keyAdded = alpha.length()- (index + key);
					}
					else if (codedText.charAt(i) == ' ') {
						keyAdded = index;
					}
					testText = testText + alpha.charAt(keyAdded);
				}
				msg = "Does " + testText + " make sense: (Y/n)";
				String crackTest = JOptionPane.showInputDialog(msg);
				if (crackTest.equalsIgnoreCase("n") || crackTest.equalsIgnoreCase("no")) {
					StopLoop = false;
					key = key + 1;
				}//end of if
				else if (crackTest.equalsIgnoreCase("y") || crackTest.equalsIgnoreCase("yes")) {
					StopLoop = true;
				}
				else {
					JOptionPane.showMessageDialog(null, "I'm sorry but I don't understand that.");
				}
			}// end of while loop
		return key;
	}

}
