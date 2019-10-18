
public class Cryptor {
	
	static int encrypt(int code) {
		int digits[] = intToArray(code, 4);
		
		// Perform encryption
		code = 0;
		for (int i = 0; i < 4; i++) {
			code *= 10;
			code += (digits[i] + 7) % 10;
		}
		
		return code;
	}
	
	static int decrypt(int code) {
		int digits[] = intToArray(code, 4);
		
		// Perform decryption
		code = 0;
		for (int i = 0; i < 4; i++) {
			code *= 10;
			code += (digits[i] + 3) % 10;
		}
		
		return code;
	}
	
	private static int[] intToArray(int val, int length) {
		int digits[] = new int[length];
		
		for (int i = 1; i <= length; i++) {
			digits[i-1] = val / (int)Math.pow(10, length - i);
			val %= (int)Math.pow(10, length - i);
		}
		
		return digits;
	}
}
