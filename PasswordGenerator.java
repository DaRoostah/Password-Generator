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
        System.out.println(GeneratePassword(characterNumber));

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
            int randNumber = rand.nextInt(4);
            password += characterChooser[randNumber].substring(rand.nextInt(characterChooser[randNumber].length())), characterChooser[randNumber].substring(rand.nextInt(characterChooser[randNumber].length())+1);
        }
        return password;
    }
}