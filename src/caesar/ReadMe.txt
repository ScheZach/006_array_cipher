Julius Caesar (Roman General/Emporer) is credited with our first "cipher."
This is a shift cipher, where each alpha is shifted by the same number. for example,
key = 1
A --> B
B --> C
to decipher, reverse the process
B-1 --> A
C-1 --> B
-----------------
Will's method
	if (keyAdded >= alpha.length()) {
		keyAdded -= alpha.length();
	}