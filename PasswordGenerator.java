import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {
    private static String lowerCaseCharacters = "abcdefghijklmnopqrstuvwxyz";
    private static String upperCaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String numberCharacters = "1234567890";
    private static String specialCharacters = "!@#$%^&*()";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many characters do you want?");
        String userInput = sc.nextLine();
        int characterNumber = Integer.parseInt(userInput);
        System.out.println("How many passwords do you want printed out?");
        userInput = sc.nextLine();
        int pwNumber = Integer.parseInt(userInput);
        for(int numOfPass = 0; numOfPass < pwNumber;numOfPass++) {
          System.out.println(numOfPass+1 + ". " + GeneratePasswordTwo(characterNumber));
        }

        sc.close();
    }
    public static char getSpecificRandomChar(int charactersList) {
        Random rand = new Random();
        char character = ' ';
        String[] characterChooser = new String[4];
        characterChooser[0] = lowerCaseCharacters;
        characterChooser[1] = upperCaseCharacters;
        characterChooser[2] = numberCharacters;
        characterChooser[3] = specialCharacters;
        int randChar = rand.nextInt(characterChooser[charactersList].length());
        character = characterChooser[charactersList].charAt(randChar);
        return character;
    }

    public static String GeneratePasswordTwo(int characterNumber) {
        Random rand = new Random();
        String password = "";
        int intPWswitch = 0;
        for(int passwordChar = 0; passwordChar < characterNumber; passwordChar++) {
            password += getSpecificRandomChar(intPWswitch);
            intPWswitch++;
            if(intPWswitch == 4)
                intPWswitch = 0;
            
        }
        return password;
    }
}