import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {
    private static String lowerCaseCharacters = "abcdefghijklmnopqrstuvwxyz";
    private static String upperCaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String numberCharacters = "1234567890";
    private static String specialCharacters = "!@#$%^&*()";
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many characters do you want?");
        String userInput = sc.nextLine();
        int characterNumber = Integer.parseInt(userInput);
        System.out.println("How many passwords do you want printed out?");
        userInput = sc.nextLine();
        int pwNumber = Integer.parseInt(userInput);
        for(int numOfPass = 0; numOfPass < pwNumber;numOfPass++) {
          System.out.println(numOfPass+1 + ". " + GeneratePassword(characterNumber));
        }

    }
    public static String GeneratePassword(int characterNumber) {
        Random rand = new Random();
        String[] characterChooser = new String[4];

        
        characterChooser[0] = lowerCaseCharacters;
        characterChooser[1] = upperCaseCharacters;
        characterChooser[2] = numberCharacters;
        characterChooser[3] = specialCharacters;
        String password = "";
        for(int passwordChar = 0; passwordChar < characterNumber; passwordChar++) {
            int randNumber = rand.nextInt(characterChooser.length), randChar = rand.nextInt(characterChooser[randNumber].length());
            password += characterChooser[randNumber].substring(randChar, randChar+1 );
        }
        return password;
    }
}