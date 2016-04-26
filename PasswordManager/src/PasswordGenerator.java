import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {

	static Random rng = new Random();
	static String tempPassword = "";
	
	public static void passwordGen() {
		char tempChar;
		List<String> passwordChars = new LinkedList<String>();
		
		for (int i = 0; i<12; i++){
			if(i<3){
				tempChar = (char) (rng.nextInt(26)+65);
				passwordChars.add(Character.toString(tempChar));
			}
			else if(i<6){
				tempChar = (char) (rng.nextInt(26)+97);
				passwordChars.add(Character.toString(tempChar));
			}
			else if(i<9){
				tempChar = (char) (rng.nextInt(15)+33);
				passwordChars.add(Character.toString(tempChar));
			}
			else{
				tempChar = (char) (rng.nextInt(10)+48);
				passwordChars.add(Character.toString(tempChar));
			}
		}
		
		for (int i=0; i<12; i++){
			int rand = rng.nextInt(passwordChars.size());
			tempPassword = tempPassword + passwordChars.get(rand);
			passwordChars.remove(rand);
		}

	}
}
