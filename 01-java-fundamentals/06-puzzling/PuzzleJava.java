import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * PuzzleJava
 */
public class PuzzleJava {

    //getTenRolls
    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> random10 = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 1; i <= 10; i++){
            random10.add(rand.nextInt(20) + 1);
        }
        return random10;
    }
    //getRandomLetter
    public String randomLetter(){
        Random r = new Random();
        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabet = new String[26];
        for (int i = 0; i < 26; i++){
            alphabet[i] = String.valueOf(alphabetString.charAt(i));
        }
        return alphabet[r.nextInt(26)];
    }
    //generatePassword.
    public String createPassword() {
        String password = "";
        for (int i = 0; i < 8; i++){
            password = password + randomLetter();
        }
        return password;
    }
    //getNewPasswordSet
    public ArrayList<String> setNewPassword(int length){
        ArrayList<String> passwordSet = new ArrayList<String>();
        for(int i = 0; i <length; i++){
            passwordSet.add(createPassword());
        }
        return passwordSet;
    }
}