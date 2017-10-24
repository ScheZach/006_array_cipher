package caesar;

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
			keyAdded = index + key;
			//Doug's Method
			keyAdded = (index + key) % alpha.length();
			
			//System.out.println(keyAdded);
			//System.out.println(alpha.charAt(keyAdded));
			secretText = secretText + alpha.charAt(keyAdded);
		}
		System.out.println("\nYour secert message is " + secretText);
		return secretText;
		
	}
	//Each char that I read from plainText I find the index in alpha
	//for example, read A look up index for A get 0
	//then, add key to that index, so A index 0 becomes 0 + key
	//and 0+key becomes my coded char

}
