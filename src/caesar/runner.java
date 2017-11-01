package caesar;

import javax.swing.JOptionPane;

public class runner {

	public static void main(String[] args) {
		
		String msg = "";
		boolean StopLoop = false;
		String ConfirmStart = "Yes";
		

		
		while(StopLoop == false) {
			/*
			msg = "Would you like to encode a plain text message?";
			int comfirm = JOptionPane.showConfirmDialog(null, msg);
			Scanner kbd = new Scanner(System.in);
			*/
			String plainText = "";
			int key = 0;
			String codedText = "";
			
			
			Object[] possibilities = {"Encode", "Decode", "Crack", "Exit"};
			String showFirst = "Encode";
			String selection = (String) JOptionPane.showInputDialog(null, "Please make your Selection", 
					"Start Here",
					JOptionPane.PLAIN_MESSAGE,
					null,
					possibilities,
					showFirst);
			if (selection == null) {
				selection = "Cancelled";
				JOptionPane.showMessageDialog(null, "You have selected: " + selection);
			}//end of if
			/*
			else if (selection.equalsIgnoreCase("Encode")) {
				CaesarCipher myCipher = new CaesarCipher();
				msg = "Please enter the plain text to encode:";
				String plainText = JOptionPane.showInputDialog(msg).toLowerCase();
				msg = "Please enter the key:";
				int key = Integer.parseInt(JOptionPane.showInputDialog(msg));
				//System.out.println("Your key is " + key);
				String codedText = myCipher.encode(plainText, key);
				JOptionPane.showMessageDialog(null, "Your encoded message is: " + codedText);
			}//end of if
			*/
			CaesarCipher myCipher = new CaesarCipher();
			switch (selection) {
			case "Encode":
				msg = "Please enter the plain text to encode:";
				plainText = JOptionPane.showInputDialog(msg).toLowerCase();
				msg = "Please enter the key:";
				key = Integer.parseInt(JOptionPane.showInputDialog(msg));
				//System.out.println("Your key is " + key);
				codedText = myCipher.encode(plainText, key);
				JOptionPane.showMessageDialog(null, "Your encoded message is: " + codedText);
				break;
			case "Decode":
				msg = "Please enter the encoded text to encode:";
				codedText = JOptionPane.showInputDialog(msg).toLowerCase();
				msg = "Please enter the key:";
				key = Integer.parseInt(JOptionPane.showInputDialog(msg));
				//System.out.println("Your key is " + key);
				String decodedText = myCipher.decode(codedText, key);
				JOptionPane.showMessageDialog(null, "Your encoded message is: " + decodedText);
				break;
			case "Crack":
				JOptionPane.showMessageDialog(null, "Crack");
				break;
			case "Exit":
				JOptionPane.showMessageDialog(null, "Sorry for wasting your time");
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "I didn't understand that");
				break;
			}
			msg = "Do you want to do this again? (Y/n)";
			ConfirmStart = JOptionPane.showInputDialog(msg);
			if (ConfirmStart.equalsIgnoreCase("n") || ConfirmStart.equalsIgnoreCase("no")) {
				StopLoop = true;
				JOptionPane.showMessageDialog(null, "Thank you for using my program");
			}//end of if
			else if (ConfirmStart.equalsIgnoreCase("y") || ConfirmStart.equalsIgnoreCase("yes")) {
				StopLoop = false;
			}
			else {
				JOptionPane.showMessageDialog(null, "I'm sorry but I don't understand that.");
			}
		}//end of while
	}

}
