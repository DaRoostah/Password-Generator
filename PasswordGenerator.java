import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {
    private static String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    private static String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String numbers = "1234567890";
    private static String upperCaseNumbers = "!@#$%^&*()";
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many characters do you want?");
        String userInput = sc.nextLine();
        int characterNumber = Integer.parseInt(userInput);
        System.out.println(GeneratePassword(characterNumber));

    }
    public static String GeneratePassword(int characterNumber) {
        String password = "";
        for(int i = 0;i != characterNumber;i++){
            
        }
        return password;
    }
}